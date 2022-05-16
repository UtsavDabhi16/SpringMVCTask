package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import com.spring.model.AddressBean;
import com.spring.model.UserBean;

public interface UserService {

	boolean userRegistrationService(UserBean ubean);

	UserBean getUserByEmail(String email) throws SQLException;

	List<AddressBean> getUserAddress(UserBean ubean) throws SQLException;

	int updateUser(UserBean user);

	List<UserBean> showUser();

	void deleteUser(int userId);

	int forgotPassword(String email, String phone, String sQuestion, String NPassword);

	void resetPassword(String oldPass, String newPass, String cPass);

	boolean checkEmail(String email);
}
