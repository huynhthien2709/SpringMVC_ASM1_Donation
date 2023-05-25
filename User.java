package com.asm1.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "is required")
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "note")
	private String note;
	
	@NotNull(message = "is required")
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "status")
	private int status;
	
	@NotNull(message = "is required")
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "created")
	private String created;	
	
	
	//foreign key reference to role_id in role table
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	//relation to userDonation, reference user_id
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserDonation> userDonations;

	public User() {
	}

	

	public User(String address, String email, @NotNull(message = "is required") String fullName, String note,
			@NotNull(message = "is required") String password, String phoneNumber, int status,
			@NotNull(message = "is required") String userName, String created) {
		this.address = address;
		this.email = email;
		this.fullName = fullName;
		this.note = note;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.userName = userName;
		this.created = created;
	}

	
	//Getter and setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public List<UserDonation> getUserDonations() {
		return userDonations;
	}



	public void setUserDonations(List<UserDonation> userDonations) {
		this.userDonations = userDonations;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", email=" + email + ", fullName=" + fullName + ", note="
				+ note + ", password=" + password + ", phoneNumber=" + phoneNumber + ", status=" + status
				+ ", userName=" + userName + ", created=" + created + "]";
	}
	
	
	
	
	
	
	
	
	
}
