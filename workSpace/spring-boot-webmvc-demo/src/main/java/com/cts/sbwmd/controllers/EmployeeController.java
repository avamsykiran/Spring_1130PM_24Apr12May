package com.cts.sbwmd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.services.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ModelAndView employeesListAction() {
		return new ModelAndView("emps/list-page", "emps", empService.findAll());
	}
	
	@GetMapping("/search")
	public ModelAndView employeesSearchAction() {
		return new ModelAndView("emps/search-page");
	}
}
