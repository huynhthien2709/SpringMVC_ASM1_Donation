package com.asm1.entity;

public class UserDonationDTO {

	private int id;

	private String created;

	private int money;

	private String name;

	private int status;

	private String text;

	private int donationId;

	private int userId;

	private User user;

	private Donation donation;

	public UserDonationDTO() {
	}

	public UserDonationDTO(String created, int money, String name, int status, String text, int donationId,
			int userId) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
		this.donationId = donationId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

}
