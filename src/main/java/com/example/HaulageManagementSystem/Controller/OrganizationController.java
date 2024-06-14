package com.example.HaulageManagementSystem.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.HaulageManagementSystem.Entity.*;

import com.example.HaulageManagementSystem.Service.*;

@Controller
@RequestMapping("organization")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@GetMapping("organizationForm")
	public String organizationForm(Model model) {
		
		model.addAttribute("organization", new Organization());

		return "addOrganization";
	}
	
	@PostMapping("saveOrganization")
	public String saveOrganization(@Valid @ModelAttribute("organization") Organization organization, BindingResult bindingResult,
			Model model) {
		
		System.out.println("bindingResult : "+bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("in if");
			return "addOrganization";		   
		}
		else {
			System.out.println("in else");
			organizationService.saveObject(organization);
			return "redirect:organizationForm";
		}

	}
	
	
}
