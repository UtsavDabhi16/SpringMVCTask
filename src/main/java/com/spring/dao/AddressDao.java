package com.spring.dao;

import java.util.List;

import com.spring.generic.GenericDao;
import com.spring.model.AddressBean;

public interface AddressDao extends GenericDao<AddressBean>{
	
	 List<Integer> getAddressIds(int uid);
}
