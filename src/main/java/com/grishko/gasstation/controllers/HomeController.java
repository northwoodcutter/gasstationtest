package com.grishko.gasstation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grishko.gasstation.models.Dispenser;
import com.grishko.gasstation.models.Engine;
import com.grishko.gasstation.models.Pistol;
import com.grishko.gasstation.services.DispenserService;
import com.grishko.gasstation.services.PartService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired(required = true)
	@Qualifier(value = "dispenserService")
    private DispenserService dispenserService;
	
	@SuppressWarnings("rawtypes")
	@Autowired(required = true)
	@Qualifier(value = "partService")
    private PartService partService;
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("dispenser", new Dispenser());
		Engine engineType = new Engine();
		model.addAttribute("engineList", partService.getList(engineType));
		Pistol pistol = new Pistol();
		model.addAttribute("pistolList", partService.getList(pistol));
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("dispenserList", dispenserService.getDispensers());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDispenser(@ModelAttribute("dispenser") Dispenser dispenser){
		dispenserService.addDispenser(dispenser);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteDispenser(@PathVariable("id") Integer id){
		dispenserService.deleteDispenser(id);
		return "redirect:/list";
	}
}
