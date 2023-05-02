package com.cts.sbjd.services;

import java.util.List;

import com.cts.sbjd.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int empId);
	Employee add(Employee emp);
	Employee save(Employee emp);
	void deleteById(int empId);

}
