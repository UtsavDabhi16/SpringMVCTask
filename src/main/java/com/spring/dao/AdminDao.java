package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.generic.GenericDao;
import com.spring.model.AssignBean;
import com.spring.model.UserBean;

public interface AdminDao extends GenericDao<UserBean> {

	List<AssignBean> userType(UserBean bean) throws SQLException;

}
