package com.project.aircnc.trip;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	@Autowired 
	private TripService service;
	
	@RequestMapping(value = "/trip", method = RequestMethod.GET)
	public String trip (HttpSession hs, Model model) {
		model.addAttribute("af_data",service.selReser(hs)); // 여행 예정 data
		model.addAttribute("bf_data",service.selBfReser(hs)); // 이전 여행 data
		
		return "/trip/trip";
	}
	
}
