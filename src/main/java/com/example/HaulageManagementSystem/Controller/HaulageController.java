package com.example.HaulageManagementSystem.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.HaulageManagementSystem.Entity.HService;
import com.example.HaulageManagementSystem.Entity.Haulage;
import com.example.HaulageManagementSystem.Entity.HaulageItem;
import com.example.HaulageManagementSystem.Service.CountryService;
import com.example.HaulageManagementSystem.Service.DistrictService;
import com.example.HaulageManagementSystem.Service.HaulageService;
import com.example.HaulageManagementSystem.Service.ServiceHaulageService;
import com.example.HaulageManagementSystem.Service.StateService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("Form")
public class HaulageController {

	@Autowired
	DistrictService districtService;

	@Autowired
	StateService stateService;

	@Autowired
	CountryService countryService;

	@Autowired
	private HaulageService haulageService;
	
	@Autowired
	private ServiceHaulageService hService;
	
	

	@GetMapping("haulage")
	public String HaulageForm(Model model) {

		model.addAttribute("countrylist", countryService.getAll());

		model.addAttribute("statelist", stateService.getAll());

		model.addAttribute("districtlist", districtService.getAll());
		
		model.addAttribute("haulageCentreList" , haulageService.getAll());
		

		Haulage haulage = new Haulage();
		haulage.getHaulageItem().add(new HaulageItem());
		model.addAttribute("haulage", haulage);

		HaulageItem haulageitem = new HaulageItem();
		haulage.getHaulageItem().add(new HaulageItem());
		model.addAttribute("haulageitem", haulageitem);

		return "Form1";

	}

//	@GetMapping("/studentManage")
//	private String manageStudent(Model model, Student student,
//			@RequestParam(value = "mobileNo", required = false) String mobileNo,
//			@RequestParam(value = "firstName", required = false) String firstName,
//			@RequestParam(value = "usercode", required = false) String usercode,
//			@RequestParam(value = "mixedFilter", required = false) String mixedFilter,
//			@RequestParam(value = "clgUnivClass", required = false) Long classId,
//			@RequestParam(value = "clgUnivSemester", required = false) Long semesterID,
//			@RequestParam(value = "state", required = false) Integer state,
//			@RequestParam(value = "clgUniv", required = false) Long universityCollegeID) {
//		List<Student> studentList = null;
//		Branch branch = (Branch) webRequest.getAttribute("branch", RequestAttributes.SCOPE_SESSION);
//
//		List<CollegeUniversityClass> CollegeUniversityClassList = collegeUniversityClassService.getAllData();
//		model.addAttribute("CollegeUniversityClassList", CollegeUniversityClassList);
//
//		List<CollegeUniversity> CollegeUniversity = collegeUniversityService.getAllData();
//		model.addAttribute("CollegeUniversity", CollegeUniversity);
//
//		List<CollegeUniversitySemester> SemesterList = collegeUniversitySemesterService.getAllData();
//		model.addAttribute("SemesterList", SemesterList);
//
//		List<Country> countryList = countryService.getAllCountry();
//		model.addAttribute("countryList", countryList);
//
//		if (mobileNo != null) {
//			studentList = studentService.findAllStudentByContactNo(branch.getId(), mobileNo);
//		} else if (firstName != null) {
//			studentList = studentService.findByBranchIdAndFirstName(branch.getId(), firstName);
//		} else if (usercode != null) {
//			studentList = studentService.findByBranchIdAndStudentCode(branch.getId(), usercode);
//		}
//
//		else if (mixedFilter != null) {
//			studentList = studentService.getDataThroughMixedFilters(branch.getId(), universityCollegeID, classId,
//					semesterID);
//		}
//
//		else if (state != null) {
//			studentList = studentService.findByBranchIdAndState(branch.getId(), state);
//		} else {
//			studentList = studentService.fildAllStudentFromBranchId(branch.getId());
//		}
//		model.addAttribute("studentList", studentList);
//		return "studentms/studentManage";
//	}

	@GetMapping("haulagemanage")
	public String HaulageManageForm(Model model,

			@RequestParam(value = "client-name", required = false) String clientName,
			@RequestParam(value = "Client-MobileNo", required = false) String clientMobileNo,
			@RequestParam(value = "reciever_Name", required = false) String Rname,
			@RequestParam(value = "tracking_code", required = false) String tracking_code,
			@RequestParam(value = "booking_date", required = false) String bookingDate,
			@RequestParam(value = "status", required = false) String status) {

		List<Haulage> haulagelist = new ArrayList<Haulage>();

		System.out.println("This is date :" + bookingDate);

		if (clientName != null) {
			haulagelist = haulageService.getByClientName(clientName);

		} else if (clientMobileNo != null) {
			haulagelist = haulageService.getByClient_MobileNo(clientMobileNo);

		} else if (tracking_code != null) {
			haulagelist = haulageService.getByTrackingCode(tracking_code);

		} else if (bookingDate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate parsedDate = LocalDate.parse(bookingDate, formatter);
			haulagelist = haulageService.getByBookingDate(parsedDate);

		} else if (status != null) {
			haulagelist = haulageService.findByName(status);

		}

		else

		{
			haulagelist = haulageService.getAll();
		}
		model.addAttribute("haulagelist", haulagelist);

		return "haulage_manage";
	}

	@GetMapping("view")
	public String ViewDetailForm(@RequestParam("id") Long id, Model model) {
		List<Haulage> List = haulageService.getAll();
		model.addAttribute("List", List);

		Haulage haulage = haulageService.getById(id);
		model.addAttribute("haulage", haulage);

		return "view_courier_details";
	}

	@PostMapping("saveHaulage")
	public String saveHaulage(@Valid @ModelAttribute("haulage") Haulage haulage, BindingResult bindingResult,
			Model model) {
		// for sender
		if (haulage.getSender_District().getState().getCountry().getId() == null) {

			bindingResult.rejectValue("sender_District.state.country.id", null, "please select country ");
		}
		if (haulage.getSender_District().getState().getId() == null) {

			bindingResult.rejectValue("sender_District.state.id", null, "please select state ");
		}
		if (haulage.getSender_District().getId() == null) {

			bindingResult.rejectValue("sender_District.id", null, "please select district ");
		}

		// for receiver//

		if (haulage.getReciever_District().getState().getCountry().getId() == null) {

			bindingResult.rejectValue("reciever_District.state.country.id", null, "please select country ");
		}
		if (haulage.getReciever_District().getState().getId() == null) {

			bindingResult.rejectValue("reciever_District.state.id", null, "please select state ");
		}
		if (haulage.getReciever_District().getId() == null) {

			bindingResult.rejectValue("reciever_District.id", null, "please select district ");
		}

		System.out.println("bindingResult : " + bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("in if");
			return "Form1";
		} else {

			for (int i = 0; i < haulage.getHaulageItem().size(); i++) {
				haulage.getHaulageItem().get(i).setHaulage(haulage);
			}

			System.out.println("in else");
			haulageService.saveHaulage(haulage);
			return "redirect:haulage";
		}

	}

	@ResponseBody
	@GetMapping("/view-specific")
	public String viewSpecific() {

		List<Haulage> haulages = haulageService.getByClientName("jassi");
		String id = "";
		if (haulages.isEmpty()) {
//			for(Haulage haulage: haulages) {
//			}
			return "Empty!";
		}
		id = haulages.get(0).getSender_MobileNo() + "";
		return "Not Empty! mob: " + id;
	}

	@GetMapping("haulagecancel")
	public String cancelHaulage(@RequestParam("id") Long id) {
		System.out.println("Hello : " + id);
		haulageService.updateStatus(id);
		return "redirect:haulagemanage";

	}
	
	@PostMapping("saveService")
	public String saveService(@Valid @ModelAttribute("haulage") HService haulage, Model model) {
		hService.saveDetails(haulage);
		model.addAttribute("successMessage", "Haulage Service saved successfully!");
		return "redirect:haulageService";
	}

	@GetMapping("haulageService")
	public String HService(Model model) {

		List<HService> HSLsit = hService.getAll();
		model.addAttribute("HSLsit", HSLsit);
		model.addAttribute("haulage", new HService());
		return "haulageService";

	}

	@GetMapping("updateService")
	public String update(Model model, @ModelAttribute("id") Long id) {

		List<HService> HSLsit = hService.getAll();
		model.addAttribute("HSLsit", HSLsit);
		HService haulageService = hService.update(id);
		model.addAttribute("haulage", haulageService);
		return "HaulageService";

	}

}
