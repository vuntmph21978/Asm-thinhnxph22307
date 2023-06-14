package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"", "/", "/index",}, method = RequestMethod.GET)
	public ModelAndView homePage(HttpSession session) {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		m.addObject("message", "Hellooooooo");
		return m;
	}
	@RequestMapping(value = {"/home",}, method = RequestMethod.GET)
	public ModelAndView homeePage(HttpSession session) {
		ModelAndView m = new ModelAndView();
		m.setViewName("trangchu");
		return m;
	}
	

}
