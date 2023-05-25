package com.asm1.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asm1.entity.Donation;
import com.asm1.entity.Role;
import com.asm1.entity.User;
import com.asm1.entity.UserDTO;
import com.asm1.entity.UserDonation;
import com.asm1.entity.UserDonationDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//get list user from database
	@Override
	public List<User> getUsers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	//get list role from database
	@Override
	public List<Role> getRoles() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Role> theQuery = currentSession.createQuery("from Role", Role.class);

		List<Role> roles = theQuery.getResultList();

		return roles;
	}

    //add user to db
	//use class UserDTO to get input from view and save to class User and save to db
	@Override
	public User addUser(UserDTO theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		User newUser = new User();
		Role r = new Role();
		r.setId(Integer.parseInt(theUser.getRole()));		
		newUser.setAddress(theUser.getAddress());
		newUser.setCreated(theUser.getCreated());
		newUser.setEmail(theUser.getEmail());
		newUser.setFullName(theUser.getFullName());
		newUser.setId(theUser.getId());
		newUser.setNote(theUser.getNote());
		newUser.setPassword(theUser.getPassword());
		newUser.setPhoneNumber(theUser.getPhoneNumber());
		newUser.setRole(r);
		newUser.setStatus(theUser.getStatus());
		newUser.setUserDonations(theUser.getUserDonations());
		newUser.setUserName(theUser.getUserName());

		currentSession.saveOrUpdate(newUser);
		return newUser;

	}

	@Override
	public List<User> searchUser(String searchValue) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (searchValue != null && searchValue.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from User where phoneNume like :searchInput or lower(email) like :searchInput", User.class);
			theQuery.setParameter("searchInput", "%" + searchValue.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from User", User.class);
		}

		List<User> users = theQuery.getResultList();

		return users;
	}
	
	//unlock user
	//update to 1, if status == 1 => user is active
	@Override
	public void unlockUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User u = (User) currentSession.get(User.class, id);
		u.setStatus(1);
		currentSession.save(u);
	}

	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		User users = currentSession.get(User.class, id);

		return users;

	}

	//lock user
	//update to 0, if status == 0 => user is deactivate
	@Override
	public void lockUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User u = (User) currentSession.get(User.class, id);
		u.setStatus(0);
		currentSession.save(u);
		
	}

	//delete user by id
	//id get by javascript
	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		Query theQuery = currentSession.createQuery("delete from User where id =:id");
		theQuery.setParameter("id", id);		
		theQuery.executeUpdate();
		
	}

	//user class userDTO to get mail and pass from view
	//and use mail and pass to execute query to take user from db
	@Override
	public UserDTO getUserLogin(UserDTO userDTO) {
 		Session currentSession = sessionFactory.getCurrentSession(); 
		User user = new User();	
		Query theQuery = currentSession.createQuery("from User where email =:email and password =:password", User.class);
		theQuery.setParameter("email", userDTO.getEmail());
		theQuery.setParameter("password", userDTO.getPassword());
		user = (User) theQuery.uniqueResult();
		if (user == null) {
			return null;
		}else {
			userDTO.setEmail(user.getEmail());
			userDTO.setPassword(user.getPassword());
			userDTO.setFullName(user.getFullName());
			userDTO.setRole(Integer.toString(user.getRole().getId()));	
			userDTO.setId(user.getId());
			userDTO.setStatus(user.getStatus());
			user.setCreated(userDTO.getCreated());
			return userDTO;
		}
		
	}

	//class UserDonationDTO get input from view and save to db
	@Override
	public UserDonation addUserDonation(UserDonationDTO userDonationDTO) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		UserDonation userDonation = new UserDonation();
		userDonation.setName(userDonationDTO.getName());
		userDonation.setMoney(userDonationDTO.getMoney());
		userDonation.setText(userDonationDTO.getText());
		userDonation.setDonationId(userDonationDTO.getDonationId());
		userDonation.setUserId(userDonationDTO.getUserId());
		userDonation.setId(userDonationDTO.getId());
		userDonation.setStatus(userDonationDTO.getStatus());
		
		currentSession.save(userDonation);
	
		return userDonation;
	}

	//when admin click confirm button => display a form allow admin review user_donation info and update user_Donation info if it necessary
	@Override
	public UserDonation confirmUserDonation(UserDonationDTO userDonationDTO) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		UserDonation userDonation = new UserDonation();
		userDonation.setName(userDonationDTO.getName());
		userDonation.setMoney(userDonationDTO.getMoney());
		userDonation.setText(userDonationDTO.getText());
		userDonation.setDonationId(userDonationDTO.getDonationId());
		userDonation.setUserId(userDonationDTO.getUserId());
		userDonation.setId(userDonationDTO.getId());
		userDonation.setStatus(1);
		
		currentSession.saveOrUpdate(userDonation);
	
		return userDonation;
	
	}

	
   //cancel userDonation if user don't pay thier donation
	@Override
	public void cancelUserDonation(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		UserDonation userDonation = (UserDonation) currentSession.get(UserDonation.class, id);
		userDonation.setStatus(0);
		userDonation.getDonationId();
		
		currentSession.save(userDonation);
		
		
	}

	



}
