package com.cts.sbwmd.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.model.Designation;
import com.cts.sbwmd.model.Employee;
import com.cts.sbwmd.services.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@ModelAttribute("designations")
	public Designation[] designations() {
		return Designation.values();
	}

	@GetMapping
	public ModelAndView employeesListAction() {
		return new ModelAndView("emps/list-page", "emps", empService.findAll());
	}

	@GetMapping("/search")
	public ModelAndView employeesSearchAction(
			@RequestParam(name = "searchValue", required = false) String searchValue) {

		List<Employee> emps = null;

		if (searchValue != null) {
			if (searchValue.matches("\\d{1,10}")) {
				int empId = Integer.parseInt(searchValue);
				Employee emp = empService.findById(empId);
				if (emp != null) {
					emps = Collections.singletonList(emp);
				}

			} else {
				String empName = searchValue;
				emps = empService.findByName(empName);
			}
		}
		return new ModelAndView("emps/search-page", "emps", emps);
	}

	@GetMapping("/add")
	public ModelAndView showEmployeeFormAction() {
		return new ModelAndView("emps/emp-form-page", "emp", new Employee());
	}

	@PostMapping("/add")
	public String addEmployeeAction(@ModelAttribute("emp") Employee emp) {
		empService.add(emp);
		return "redirect:/emps";
	}

	@GetMapping("/edit")
	public ModelAndView showEmployeeFormForEditAction(@RequestParam("id") int empId) {
		return new ModelAndView("emps/emp-form-page", "emp", empService.findById(empId));
	}

	@PostMapping("/edit")
	public String updateEmployeeAction(@ModelAttribute("emp") Employee emp) {
		empService.save(emp);
		return "redirect:/emps";
	}

	@GetMapping("/delete")
	public String deleteEmployeeAction(@RequestParam("id") int empId) {
		empService.deleteById(empId);
		return "redirect:/emps";
	}

}
