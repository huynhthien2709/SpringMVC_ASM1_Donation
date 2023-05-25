package com.asm1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm1.entity.Donation;
import com.asm1.entity.DonationDTO;
import com.asm1.entity.UserDonation;
import com.asm1.service.DonationService;

@Controller
@RequestMapping(value = "/donation")
public class DonationController {

	@Autowired
	private DonationService donationService;

	@GetMapping("/list")
	public String listDonation(Model theModel) {
		List<Donation> donations = donationService.getDonations();
		theModel.addAttribute("donations", donations);
		return "admin/donation";
	}

	@PostMapping("/addDonation")
	public String addDonation(@ModelAttribute("donationDTO") DonationDTO donationDTO) {
		Donation donations = donationService.addDonation(donationDTO);

		return "redirect:/donation/list";
	}

	@GetMapping("/deleteDonation/{id}")
	public String deleteDonation(@PathVariable("id") int id) {
		donationService.deleteDonation(id);
		return "redirect:/donation/list";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model theModel) {		
		DonationDTO donationDTO = donationService.getDonation(id);
		List<UserDonation> userDonation = donationService.getUserDonation();
		theModel.addAttribute("donationDTO", donationDTO);
		theModel.addAttribute("userDonation", userDonation);
		return "admin/detail";
	}
	@GetMapping("/updateStatusDonation/{id}")
	public String updateStatusDonation(@PathVariable("id") int id) {
		donationService.updateStatusDonation(id);
		return "redirect:/donation/list";
	}
	@GetMapping("/detailDonation/{id}")
	public String detailDonation(@PathVariable("id") int id, Model theModel) {		
		List<UserDonation> userDonation = donationService.getUserDonation();
		DonationDTO donationDTO = donationService.getDonation(id);
		theModel.addAttribute("userDonation", userDonation);		
		theModel.addAttribute("donationDTO", donationDTO);
		return "public/detail";
	}
	@GetMapping("/finishDonation/{id}")
	public String finishDonation(@PathVariable("id") int id) {
		donationService.finishDonation(id);
		return "redirect:/donation/list";
	}
	
}
