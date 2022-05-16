package com.spring.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.spring.dao.AdminDao;
import com.spring.dao.UserDao;
import com.spring.model.AssignBean;
import com.spring.model.UserBean;
import com.spring.service.AdminService;

@Service
public class AdminImpl implements AdminService {

	@Autowired
	@Qualifier(value = "adminDaoImpl")
	AdminDao adminDao;

	@Autowired
	UserDao udao;

	@Override
	public boolean checkLogin(String email, String pass) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AssignBean> checkUserType(UserBean bean) throws SQLException {
		
		UserBean uBean=udao.getUserEmail(bean.getEmail());
		List<AssignBean> usertype = adminDao.userType(uBean);
		return usertype;

	}

}
