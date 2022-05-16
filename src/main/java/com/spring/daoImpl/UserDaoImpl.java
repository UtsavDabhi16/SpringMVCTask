package com.spring.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.spring.dao.UserDao;
import com.spring.generic.GenericDaoImpl;
import com.spring.model.AddressBean;
import com.spring.model.UserBean;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserBean> implements UserDao {

	@Autowired
	HibernateTemplate hibernatetamplate;

	@Autowired
	UserBean uBean;


	@Override
	public UserBean getUserEmail(String email) {
		String query = "from UserBean where Email=?0";
		Object quertParam = email;
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<UserBean> userData = (List<UserBean>) hibernatetamplate.find(query, quertParam);
		System.out.println("inside :" + userData.size());
		return userData.get(0);
	}

	public HibernateTemplate getHibernatetamplate() {
		return hibernatetamplate;
	}

	public void setHibernatetamplate(HibernateTemplate hibernatetamplate) {
		this.hibernatetamplate = hibernatetamplate;
	}

	@Override
	public List<AddressBean> getCurrentUserAddress(UserBean ubean) {
		String query = "from AddressBean where user_Userid=?0";
		Object quertParam = ubean.getUserid();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<AddressBean> userAddressData = (List<AddressBean>) hibernatetamplate.find(query, quertParam);
		return userAddressData;
	}

	@Override
	public List<UserBean> getAllUser() {
		String query = "from UserBean";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<UserBean> userData = (List<UserBean>) hibernatetamplate.find(query);
		return userData;
	}

	@Override
	public int getUserid(String email) {
		
		String query = "select Userid from UserBean where Email=?0";

		Object queryParam = email;

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Integer> uids = (List<Integer>) hibernateTemplate.find(query, queryParam);

		int uid = 0;
		
		if (uids.size() == 1) {
			uid = uids.get(0);
		}
		return uid;

	}

}
