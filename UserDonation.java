package com.asm1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_donation")
public class UserDonation {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "created")
	private String created;

	@Column(name = "money")
	private int money;

	@NotNull(message = "is required")
	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private int status;

	@Column(name = "text")
	private String text;

	@NotNull(message = "is required")
	@Column(name = "donation_id")
	private int donationId;

	@NotNull(message = "user_id")
	@Column(name = "user_id")
	private int userId;

	//relation with user, reference column id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private User user;

	//relation with donation, reference column id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Donation donation;

	public UserDonation() {
	}

	public UserDonation(String created, int money, @NotNull(message = "is required") String name, int status,
			String text, @NotNull(message = "is required") int donationId, @NotNull(message = "user_id") int userId) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
		this.donationId = donationId;
		this.userId = userId;
	}

	//Getter and setter
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
