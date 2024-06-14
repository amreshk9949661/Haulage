package com.example.HaulageManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.HaulageManagementSystem.Entity.HaulageCenter;
import com.example.HaulageManagementSystem.Service.CountryService;
import com.example.HaulageManagementSystem.Service.DistrictService;
import com.example.HaulageManagementSystem.Service.HaulageCenterService;
import com.example.HaulageManagementSystem.Service.StateService;

import jakarta.validation.Valid;

@Controller
public class CenterController {

		@Autowired
		private HaulageCenterService centerService;

		@Autowired
		DistrictService districtService;
		
		@Autowired
		StateService stateService;

		@Autowired
		CountryService countryService;


		@GetMapping("center")
		public String showCenterForm(Model model) {

		
			model.addAttribute("countrylist", countryService.getAll());

			model.addAttribute("statelist", stateService.getAll());
			
			model.addAttribute("districtlist", districtService.getAll());

			
			List<HaulageCenter> centerList = centerService.getAll();
			model.addAttribute("centerList", centerList);
			model.addAttribute("center", new  HaulageCenter());

			return "haulageCenter";
		}

		@PostMapping("saveCenter")
		public String saveCenter(@Valid @ModelAttribute("center") HaulageCenter center, BindingResult bindingResult,
				Model model) {
//			List<HaulageCenter> centerList = centerService.getAll();

			System.out.println("bindingResult : "+bindingResult);
			if (bindingResult.hasErrors()) {
				System.out.println("in if");
				return "haulageCenter";		   
			}
			else {
				System.out.println("in else");
				centerService.saveCenter(center);
				
				return "redirect:center";
			}

		}

    	@GetMapping("updateCenter")
		public String update(@ModelAttribute("id") Long id, Model model) {

		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());
		
		model.addAttribute("districtlist", districtService.getAll());

		
			List<HaulageCenter> centerList = centerService.getAll();
			model.addAttribute("centerList", centerList);

			HaulageCenter center = centerService.update(id);
     		model.addAttribute("center", center);

			return "haulageCenter";
		}

//		@GetMapping("/delete")
//		public String delete(Long id) {
//			countryService.delete(id);
//
//			return "redirect:country";
//		}
//
//	}


}
