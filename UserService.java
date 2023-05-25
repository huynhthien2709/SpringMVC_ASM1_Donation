package com.asm1.service;

import java.util.List;

import com.asm1.entity.Role;
import com.asm1.entity.User;
import com.asm1.entity.UserDTO;
import com.asm1.entity.UserDonation;
import com.asm1.entity.UserDonationDTO;

public interface UserService {

	public List<User> getUsers();
	
	public User addUser(UserDTO theUser);
	
	public List<Role> getRoles();
	
	public List<User> searchUser(String searchValue);
	
	public void unlockUser(int id);
	
	public void lockUser(int id);
	
	public User getUser(int id);
	
	public void deleteUser(int id);
	
	public boolean checkUserLogin(UserDTO userDTO);

	public UserDonation addUserDonation(UserDonationDTO userDonationDTO);
	
	public UserDonation confirmUserDonation(UserDonationDTO userDonationDTO);

	
	public void cancelUserDonation(int id);

	
	

	
}
