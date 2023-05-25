package com.asm1.dao;

import java.util.List;

import com.asm1.entity.Donation;
import com.asm1.entity.DonationDTO;
import com.asm1.entity.User;
import com.asm1.entity.UserDonation;

public interface DonationDAO {
	
	public  List<Donation> getDonations();
	
	public Donation addDonation(DonationDTO donationDTO);
	
	public void deleteDonation(int id);
	
	public DonationDTO getDonation(int id);
	
	public void updateStatusDonation(int id);
	
	public  List<UserDonation> getUserDonation();
	
	public void finishDonation(int id);
	
	
	
}
