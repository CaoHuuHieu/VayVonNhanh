package com.vayvonnhanh;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class VayVonController {
	@Autowired
	VayVonService vayVonService;
	
	@GetMapping(value = {"/", "/home"})
	public String getHomePage(Model model) {
		model.addAttribute("services", vayVonService.getAllServicePack());
		return "home";
	}
	
	@GetMapping(value = {"/admin"})
	public String getAdminPage(Model model) {
		model.addAttribute("services", vayVonService.getAllServicePack());
		return "servicelist";
	}
	
	@GetMapping(value = {"/admin/service/{id}"})
	public String getService(Model model,  @PathVariable(name = "id", required = false) Integer id) {
		if(id != null) {
			ServicePackRequest service = vayVonService.getService(id);
			model.addAttribute("serviceinfor",service);
			return "service";
		}else {
			model.addAttribute("serviceinfor",new ServicePackRequest());
			return "service";
		}
	}
	@GetMapping(value = {"/admin/service"})
	public String getService(Model model) {
		model.addAttribute("serviceinfor",new ServicePackRequest());
		return "service";
	}
	@PostMapping("/admin/service")
	public String addNewServicePack(@ModelAttribute() ServicePackRequest serviceinfor) {
		if(serviceinfor.getId() != 0) {
			vayVonService.updateServicePack(serviceinfor.getId(), serviceinfor);
		}else
			vayVonService.addNewServicePack(serviceinfor);
		return "redirect:/admin";
	}
	
	@DeleteMapping(value = {"/admin/service/{id}"})
	public String deleteServicePack ( @PathVariable int id) {
		vayVonService.deleteServicePack(id);
		return "redirect:/admin";
	}
}

