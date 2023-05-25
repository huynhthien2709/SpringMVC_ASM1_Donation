package com.asm1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm1.dao.UserDAO;
import com.asm1.entity.Role;
import com.asm1.entity.User;
import com.asm1.entity.UserDTO;
import com.asm1.entity.UserDonation;
import com.asm1.entity.UserDonationDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}


	@Override
	@Transactional
	public List<Role> getRoles() {
	
		return userDAO.getRoles();
	}
	

	@Override
	@Transactional
	public User addUser(UserDTO theUser) {
		User user = userDAO.addUser(theUser);
		
		return user;
		
	}


	@Override
	@Transactional
	public List<User> searchUser(String searchValue) {
		List<User> users = userDAO.searchUser(searchValue);
		return users;
	}


	@Override
	@Transactional
	public void unlockUser(int id) {
		userDAO.unlockUser(id);
		
	}


	@Override
	@Transactional
	public User getUser(int id) {
		User users = userDAO.getUser(id);
		return users;
	}


	@Override
	@Transactional
	public void lockUser(int id) {
		userDAO.lockUser(id);
		
	}


	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}


	@Override
	@Transactional
	public boolean checkUserLogin(UserDTO userDTO) {
		UserDTO user = userDAO.getUserLogin(userDTO);
		if (user != null) {	
				return true;						
		}
		return false;
	}


	@Override
	@Transactional
	public UserDonation addUserDonation(UserDonationDTO userDonationDTO) {

		return userDAO.addUserDonation(userDonationDTO);
	
	}


	@Override
	@Transactional
	public UserDonation confirmUserDonation(UserDonationDTO userDonationDTO) {
		return userDAO.confirmUserDonation(userDonationDTO);
	}


	@Override
	@Transactional
	public void cancelUserDonation(int id) {
		userDAO.cancelUserDonation(id);
		
	}
}
