package com.example.simplyfly.entity;

import java.time.LocalDateTime;

import com.example.simplyfly.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String contactNumber;
	private String address;
	private Role role;
	private LocalDateTime createdAt;
	
	
	public User() {
		super();
	}


	public User(int userID, String name, String email, String password, String gender, String contactNumber,
			String address, Role role, LocalDateTime createdAt) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.address = address;
		this.role = role;
		this.createdAt = createdAt;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + ", passwordHash=" + password
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", address=" + address + ", role=" + role
				+ ", createdAt=" + createdAt + "]";
	}
	
	
}
