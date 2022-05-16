package com.spring.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.spring.dao.AdminDao;
import com.spring.generic.GenericDaoImpl;
import com.spring.model.AssignBean;
import com.spring.model.UserBean;


@Repository
public class AdminDaoImpl extends GenericDaoImpl<UserBean> implements AdminDao {

	@Autowired
	HibernateTemplate hibernatetamplate;

	public List<AssignBean>  userType(UserBean bean) {
		String query = "from AssignBean where user_Userid="+bean.getUserid()+"";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<AssignBean> userAddressData = (List<AssignBean>) hibernatetamplate.find(query);
		return userAddressData;
	}

	public HibernateTemplate getHibernatetamplate() {
		return hibernatetamplate;
	}

	public void setHibernatetamplate(HibernateTemplate hibernatetamplate) {
		this.hibernatetamplate = hibernatetamplate;
	}
}
