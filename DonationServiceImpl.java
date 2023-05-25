package com.asm1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm1.dao.DonationDAO;
import com.asm1.entity.Donation;
import com.asm1.entity.DonationDTO;
import com.asm1.entity.UserDonation;

@Service
public class DonationServiceImpl implements DonationService {
	@Autowired 
	private DonationDAO  donationDAO;

	@Override
	@Transactional
	public List<Donation> getDonations() {
		
		return donationDAO.getDonations();
	}

	@Override
	@Transactional
	public Donation addDonation(DonationDTO donationDTO) {
		Donation donations = donationDAO.addDonation(donationDTO);
		return donations;
	}

	@Override
	@Transactional
	public void deleteDonation(int id) {
		donationDAO.deleteDonation(id);
		
	}

	@Override
	@Transactional
	public DonationDTO getDonation(int id) {
		DonationDTO donationDTO = donationDAO.getDonation(id);
		return donationDTO;
	}

	@Override
	@Transactional
	public void updateStatusDonation(int id) {
		donationDAO.updateStatusDonation(id);
		
	}

	@Override
	@Transactional
	public List<UserDonation> getUserDonation() {
		
		return donationDAO.getUserDonation();
	}

	@Override
	@Transactional
	public void finishDonation(int id) {
		donationDAO.finishDonation(id);
		
	}
}
