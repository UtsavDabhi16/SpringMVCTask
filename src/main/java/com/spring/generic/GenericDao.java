package com.spring.generic;

public interface GenericDao<T> {

	int create(T t);

	T read(Object uid);

	int update(T t);

	void delete(T user);
}
