package com.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> type;

	@Autowired
	public HibernateTemplate hibernateTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public GenericDaoImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public int create(T user) {
		this.hibernateTemplate.save(user);
		return 1;
	}

	@Override
	public T read(Object uid) {
		return (T) this.hibernateTemplate.get(type,(Integer)uid);
	}

	@Override
	@Transactional
	public int update(T user) {
		this.hibernateTemplate.merge(user);
		return 1;
	}

	@Override
	@Transactional
	public void delete(T user) {
		this.hibernateTemplate.delete(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
