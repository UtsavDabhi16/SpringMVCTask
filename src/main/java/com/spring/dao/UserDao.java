package com.spring.dao;

import java.util.List;

import com.spring.generic.GenericDao;
import com.spring.model.AddressBean;
import com.spring.model.UserBean;

public interface UserDao extends GenericDao<UserBean> {

	UserBean getUserEmail(String email);

	List<AddressBean> getCurrentUserAddress(UserBean userData);
	
	List<UserBean> getAllUser();

	int getUserid(String email);
}
