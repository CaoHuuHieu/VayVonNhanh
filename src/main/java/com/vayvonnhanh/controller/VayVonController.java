package com.vayvonnhanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vayvonnhanh.request.AppDTO;
import com.vayvonnhanh.request.BankDTO;
import com.vayvonnhanh.service.UserService;
import com.vayvonnhanh.service.VayVonService;

@Controller
public class VayVonController {
	@Autowired
	VayVonService vayVonService;
	@Autowired
	UserService userService;
	@GetMapping(value = { "/", "/home" })
	public String trangChu(Model model) {
		model.addAttribute("apps", vayVonService.getApps());
		return "home";
	}

	
	@GetMapping(value = { "/vaytinchap" })
	public String trangVayTinChap(Model model) {
		model.addAttribute("banks", vayVonService.getAllBank());
		return "unsecuredloan";
	}

	@GetMapping(value = { "/admin", "/admin/apps" })
	public String trangChuQuanTriVien(Model model) {
		model.addAttribute("apps", vayVonService.getApps());
		return "app-list";
	}

	@GetMapping(value = { "/admin/app/{id}" })
	public String chiTietApp(Model model, @PathVariable(name = "id") Integer id) {
		AppDTO service = vayVonService.getAppById(id);
		model.addAttribute("app", service);
		return "app-edit";
	}
	@GetMapping(value = {"/admin/app"})
	public String trangThemApp(Model model) {
		model.addAttribute("app",new AppDTO());
		return "app-edit";
	}

	@PostMapping("/admin/app")
	public String themMoiApp(@ModelAttribute() AppDTO app) {
		if (app.getId() != 0) {
			vayVonService.updateApp(app.getId(), app);
		} else
			vayVonService.addNewApp(app);
		return "redirect:/admin";
	}

	@DeleteMapping(value = { "/admin/app/{id}" })
	public String xoaApp(@PathVariable int id) {
		vayVonService.deleteApp(id);
		return "redirect:/admin";
	}
	
	@GetMapping(value = {"/admin/banks" })
	public String trangNganHang(Model model) {
		model.addAttribute("banks", vayVonService.getAllBank());
		return "bank-list";
	}

	@GetMapping(value = { "/admin/bank/{id}" })
	public String chiTietBank(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("bank", vayVonService.getBankById(id));
		return "bank-edit";
	}
	@GetMapping(value = {"/admin/bank"})
	public String trangThemBank(Model model) {
		model.addAttribute("bank",new BankDTO());
		return "bank-edit";
	}

	@PostMapping("/admin/bank")
	public String themMoiBank(@ModelAttribute() BankDTO bank) {
		System.out.println(bank.getDiscription());
		if (bank.getId() != 0) {
		
			vayVonService.updateBank(bank.getId(), bank);
		} else
			vayVonService.addNewBank(bank);
		return "redirect:/admin/banks";
	}

	@DeleteMapping(value = { "/admin/bank/{id}" })
	public String xoaBank(@PathVariable int id) {
		vayVonService.deleteBank(id);
		return "redirect:/admin/banks";
	}
}
