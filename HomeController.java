package com.asm1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm1.entity.Donation;
import com.asm1.service.DonationService;


@Controller
@RequestMapping("/index")
public class HomeController {
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping("/index")
	public String home() {
		return "public/home";
	}
	@GetMapping("/list")
	public String listDonation(Model theModel) {
		List<Donation> donations = donationService.getDonations();
		theModel.addAttribute("donations", donations);
		return "public/home";
	}
	@GetMapping("/adminHome")
	public String adminHome() {
		return "admin/home";
	}
}
