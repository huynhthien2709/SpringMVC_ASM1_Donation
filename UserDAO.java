package com.asm1.dao;

import java.util.List;

import com.asm1.entity.Role;
import com.asm1.entity.User;
import com.asm1.entity.UserDTO;
import com.asm1.entity.UserDonation;
import com.asm1.entity.UserDonationDTO;

public interface UserDAO {
	
	public  List<User> getUsers();
	
	public User addUser(UserDTO theUser);
	
	public List<Role> getRoles();

	public List<User> searchUser(String searchValue);
	
	public User getUser(int id);
	
	public void unlockUser(int id);
	
	public void lockUser(int id);
	
	public void deleteUser(int id);
	
	public UserDTO getUserLogin(UserDTO userDTO);
	
	public UserDonation addUserDonation(UserDonationDTO userDonationDTO);
	
	public UserDonation confirmUserDonation(UserDonationDTO userDonationDTO);


	public void cancelUserDonation (int id);
	

}
