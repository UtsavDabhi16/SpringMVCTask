package com.spring.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.spring.dao.AddressDao;
import com.spring.generic.GenericDaoImpl;
import com.spring.model.AddressBean;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<AddressBean> implements AddressDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Integer> getAddressIds(int userId) {
		String query = "Select AddressId from AddressBean where user_Userid=?0";

		Object queryParam = userId;

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Integer> addressIds = (List<Integer>) hibernateTemplate.find(query, queryParam);

//		System.out.println(addressIds);

		return addressIds;

	}

}
