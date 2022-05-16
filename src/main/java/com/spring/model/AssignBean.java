package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "AssignRole")
public class AssignBean implements Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AssignId;
	
	public int getAssignId() {
		return AssignId;
	}

	public void setAssignId(int assignId) {
		AssignId = assignId;
	}

	@Value("1")
	private int id;

	@ManyToOne
	private UserBean user;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (AssignBean)super.clone();
	}
	
	public UserBean getUser() throws CloneNotSupportedException {
		return (UserBean) this.user.clone();
	}

	public void setUser(UserBean user) throws CloneNotSupportedException {
		this.user = (UserBean) user.clone();
	}

	public AssignBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public AssignBean(int id, UserBean user) throws CloneNotSupportedException {
		super();
		this.id = id;
		this.user = (UserBean) user.clone();
	}

	

}
