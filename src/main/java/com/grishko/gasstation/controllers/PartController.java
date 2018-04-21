package com.grishko.gasstation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grishko.gasstation.models.Engine;
import com.grishko.gasstation.models.Pistol;
import com.grishko.gasstation.services.PartService;

@Controller
public class PartController {

private static final Logger logger = LoggerFactory.getLogger(PartController.class);
	
	@SuppressWarnings("rawtypes")
	@Autowired(required = true)
	@Qualifier(value = "partService")
    private PartService service;
	
	@RequestMapping(value = "/engine_form", method = RequestMethod.GET)
	public String engineForm(Model model) {
		model.addAttribute("engine", new Engine());
		return "engine_form";
	}
	
	@RequestMapping(value = "/pistol_form", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("pistol", new Pistol());
		return "pistol_form";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add_engine", method = RequestMethod.POST)
	public String addEngine(@ModelAttribute("engine") Engine engine){
		service.addPart(engine);
		return "redirect:/";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add_pistol", method = RequestMethod.POST)
	public String addPistol(@ModelAttribute("pistol") Pistol pistol){
		service.addPart(pistol);
		return "redirect:/";
	}
}
