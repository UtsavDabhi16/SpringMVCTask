package com.spring.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.spring.dao.AddressDao;
import com.spring.dao.UserDao;
import com.spring.model.AddressBean;
import com.spring.model.AssignBean;
import com.spring.model.UserBean;
import com.spring.service.UserService;



@Service
public class UserImpl implements UserService {

	@Autowired
	@Qualifier(value = "userDaoImpl")
	private UserDao udao;

	@Autowired
	AddressBean address;

	@Autowired
	UserBean user;

	@Autowired
	AddressDao adao;
	
	final static String secretKey = "HelloWorld!!!";


	@Override
	public boolean userRegistrationService(UserBean ubean) {
		int count = 0;
		try {

			List<AddressBean> address = ubean.getAddress();
			
			for (AddressBean a : address) {
				a.setUser(ubean);
			}
			
			List<AssignBean> assign=ubean.getAssign();
			
			System.out.println("Assign Value size :"+assign);
			System.out.println(assign.size());
			
			for (AssignBean role : assign) {
				role.setUser(ubean);
			}

			String pass=ubean.getPassword();
			String cpass=ubean.getCPassword();
			String password = Validation.encrypt(pass, secretKey);
			String cpassword = Validation.encrypt(cpass, secretKey);

			ubean.setPassword(password);
			ubean.setCPassword(cpassword);
			ubean.setAddress(address);
			ubean.setAssign(assign);
			
			count = udao.create(ubean);

			System.out.println(ubean);

			if (count == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserBean getUserByEmail(String email) throws SQLException {
		UserBean ubean = udao.getUserEmail(email);
		return ubean;
	}

	@Override
	public List<AddressBean> getUserAddress(UserBean userData) throws SQLException {
		List<AddressBean> abean = udao.getCurrentUserAddress(userData);
		return abean;

	}

	public int updateUser(UserBean user) {

		List<AddressBean> newAddress = user.getAddress();

		List<Integer> aids = adao.getAddressIds(user.getUserid());

		for (AddressBean a : newAddress) {
			if (aids.size() > 0) {
				a.setAddressId(aids.get(0));
				aids.remove(0);
			}

			a.setUser(user);
		}

		for (int id : aids) {
			address.setAddressId(id);
			adao.delete(address);
		}

		user.setAddress(newAddress);

		udao.update(user);

		return 1;
	}

	@Override
	public List<UserBean> showUser() {
		List<UserBean> userData = udao.getAllUser();
		return userData;
	}

	@Override
	public void deleteUser(int userId) {
		user = udao.read(userId);
		udao.delete(user);
	}

	@Override
	public int forgotPassword(String email, String phone, String sQuestion, String NPassword) {
		UserBean oldUserData = udao.getUserEmail(email);
		if (email.equals(oldUserData.getEmail()) && phone.equals(oldUserData.getPhoneNo())
				&& sQuestion.equals(oldUserData.getSecurityAnswer())) {
			oldUserData.setPassword(NPassword);
			oldUserData.setCPassword(NPassword);
			udao.update(oldUserData);
		}
		return 1;
	}

	@Override
	public void resetPassword(String oldPass, String newPass, String cPass) {
		List<UserBean> list = udao.getAllUser();
		for (UserBean l : list) {
			if (l.getPassword()!= null && l.getPassword().equals(oldPass)) {
				UserBean user = udao.getUserEmail(l.getEmail());
				user.setPassword(cPass);
				user.setCPassword(cPass);
				user.setNewPassword(newPass);
				udao.update(user);
			}
		}
	}

	@Override
	public boolean checkEmail(String email) {
		return udao.getUserid(email)==0;
	}
}
