package com.cts.sbwmd.services;

import java.util.List;

import com.cts.sbwmd.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int empId);
	List<Employee> findByName(String empName);
	Employee add(Employee emp);
	Employee save(Employee emp);
	void deleteById(int empId);

}
