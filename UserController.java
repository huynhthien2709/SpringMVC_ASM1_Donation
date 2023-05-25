	package com.asm1.controller;

import java.util.List;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm1.entity.Donation;
import com.asm1.entity.DonationDTO;
import com.asm1.entity.Role;
import com.asm1.entity.User;
import com.asm1.entity.UserDTO;
import com.asm1.entity.UserDonation;
import com.asm1.entity.UserDonationDTO;
import com.asm1.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//function to get list user and display to view
	@GetMapping("/list")
	public String listUser(Model theModel) {
		List<User> users = userService.getUsers();
		List<Role> roles = userService.getRoles();
		theModel.addAttribute("users", users);
		theModel.addAttribute("roles", roles);

		return "admin/account";

	}
	
	//get new user info from view and add to system
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("userDTO") UserDTO theUser) {
		User user = userService.addUser(theUser);
		return "redirect:/user/list";
	}

	@GetMapping("/search")
	public String searchUser(@RequestParam("searchValue") String searchValue, Model theModel) {
		List<User> users = userService.searchUser(searchValue);
		theModel.addAttribute("user", users);
		return "admin/account";
	}

	//unclock user base on user_id
	@GetMapping("/unlockUser/{id}")
	public String unlockUser(@PathVariable("id") int id) {
		userService.unlockUser(id);
		return "redirect:/user/list";
	}

	//lock user base on user_id
	@GetMapping("/lockUser/{id}")
	public String lockUser(@PathVariable("id") int id) {
		userService.lockUser(id);
		return "redirect:/user/list";
	}
	
	//delete user base one user_id
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}

	@GetMapping("/getUserUpdate/{id}")
	public String getUserUpdate(@PathVariable("id") int id, Model theModel) {
		User users = userService.getUser(id);
		theModel.addAttribute("user", users);
		return "redirect:/user/list";
	}
	
	//display form login
	@GetMapping("/login")
	public String login() {

		return "admin/login";
	}
	
	//check condition when user login on view
	//base on user status to accept user login
	//base on user role to display user page or admin page
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute UserDTO userDTO, HttpServletRequest request, Model model) {
		boolean check = userService.checkUserLogin(userDTO);
		request.getSession().setAttribute("userDTO", userDTO);
		if (!check) {
			model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");	
		}
		if (check && userDTO.getStatus() == 0  ) {
			model.addAttribute("message", "Tài khoản của bạn đang tạm khóa. Vui lòng liên hệ quản trị viên để được hỗ trợ.");
			return "admin/login";
		}
		if (check && userDTO.getRole().equals("1")) {
			return "admin/home";
		} else if (check && userDTO.getRole().equals("2")) {
			return "redirect:/index/list";
		}
		
		return "admin/login";
	}
	
	
	//remove user login session
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userDTO");
		
		return "redirect:/index/list";
	}
	
	//add user to userDonation
	@PostMapping("addUserDonation")
	public String addUserDonation(@ModelAttribute UserDonationDTO userDonationDTO) {
		
		userService.addUserDonation(userDonationDTO);
		return "redirect:/index/list";
	}
	
	//function for admin to confirm donation of user when user transfer their donate
	@PostMapping("/confirmUserDonation")
	public String confirmUserDonation(@ModelAttribute UserDonationDTO userDonationDTO) {
		
		userService.confirmUserDonation(userDonationDTO);
		
		return "redirect:/donation/detail/" + userDonationDTO.getDonationId();
	}
	
	//function for admin to cancel user donation if they don't transfer their donate
	@GetMapping("/cancelUserDonation/{id}")
	public String cancelUserDonation(@PathVariable("id") int id, UserDonationDTO userDonationDTO) {
		userService.cancelUserDonation(id);
		
		return "redirect:/donation/detail/" + userDonationDTO.getDonationId();
	}

	

}












