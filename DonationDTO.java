package com.asm1.entity;

import java.util.List;

public class DonationDTO {

	private int id;

	private String code;

	private String created;

	private String description;

	private String endDate;

	private int money;

	private String name;

	private String organizationName;

	private String phoneNumber;

	private String startDate;

	private int status;

	private boolean isDelete;

	private List<UserDonation> userDonations;
	
	private List<Donation> donations;

	public DonationDTO() {
	}

	public DonationDTO(String code, String created, String description, String endDate, int money, String name,
			String organizationName, String phoneNumber, String startDate, int status, boolean isDelete) {
		this.code = code;
		this.created = created;
		this.description = description;
		this.endDate = endDate;
		this.money = money;
		this.name = name;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.status = status;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<UserDonation> getUserDonations() {
		return userDonations;
	}

	public void setUserDonations(List<UserDonation> userDonations) {
		this.userDonations = userDonations;
	}


	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", code=" + code + ", created=" + created + ", description=" + description
				+ ", endDate=" + endDate + ", money=" + money + ", name=" + name + ", organizationName="
				+ organizationName + ", phoneNumber=" + phoneNumber + ", startDate=" + startDate + ", status=" + status
				+ "]";
	}

}
