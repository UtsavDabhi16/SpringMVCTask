package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.model.AssignBean;
import com.spring.model.UserBean;

public interface AdminService {

	boolean checkLogin(String email, String pass) throws SQLException;

	List<AssignBean> checkUserType(UserBean bean) throws SQLException;

}
