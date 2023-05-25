package com.asm1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asm1.entity.Donation;
import com.asm1.entity.DonationDTO;
import com.asm1.entity.User;
import com.asm1.entity.UserDonation;

@Repository
public class DonationDAOImpl implements DonationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Donation> getDonations() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Donation> theQuery = currentSession.createQuery("from Donation where isDelete = false", Donation.class);

		List<Donation> donations = theQuery.getResultList();

		return donations;
	}

	@Override
	public Donation addDonation(DonationDTO donationDTO) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation donations = new Donation();
		donations.setCode(donationDTO.getCode());
		donations.setCreated(donationDTO.getCreated());
		donations.setDescription(donationDTO.getDescription());
		donations.setEndDate(donationDTO.getEndDate());
		donations.setId(donationDTO.getId());
		donations.setMoney(donationDTO.getMoney());
		donations.setName(donationDTO.getName());
		donations.setOrganizationName(donationDTO.getOrganizationName());
		donations.setPhoneNumber(donationDTO.getPhoneNumber());
		donations.setStartDate(donationDTO.getStartDate());
		donations.setStatus(donationDTO.getStatus());
		
		System.out.println(donations);
		currentSession.saveOrUpdate(donations);
		
		return donations;
	}

	@Override
	public void deleteDonation(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update Donation set isDelete = true where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
		
	}

	@Override
	public DonationDTO getDonation(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Donation donations = currentSession.get(Donation.class, id);
		
		DonationDTO donationDTO = new DonationDTO();
		donationDTO.setCode(donations.getCode());
		donationDTO.setName(donations.getName());
		donationDTO.setStartDate(donations.getStartDate());
		donationDTO.setEndDate(donations.getEndDate());
		donationDTO.setMoney(donations.getMoney());
		donationDTO.setStatus(donations.getStatus());
		donationDTO.setOrganizationName(donations.getOrganizationName());
		donationDTO.setPhoneNumber(donations.getPhoneNumber());
		donationDTO.setDescription(donations.getDescription());
		donationDTO.setId(donations.getId());

		return donationDTO;
	}

	@Override
	public void updateStatusDonation(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation donations = (Donation) currentSession.get(Donation.class, id);
		donations.setStatus(1);
		currentSession.save(donations);
		
	}

	@Override
	public List<UserDonation> getUserDonation() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<UserDonation> theQuery = currentSession.createQuery("from UserDonation", UserDonation.class);
		
		List<UserDonation> userDonation = theQuery.getResultList();

		return userDonation;	
	}

	@Override
	public void finishDonation(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation donations = (Donation) currentSession.get(Donation.class, id);
		donations.setStatus(2);
		currentSession.save(donations);
		
	}
}
