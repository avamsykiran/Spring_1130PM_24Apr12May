package com.cts.sbwmd.repos;

import java.util.List;

import com.cts.sbwmd.model.Employee;

public interface EmployeeRepository {
	
	List<Employee> findAll();
	Employee findById(int empId);
	List<Employee> findByEmployeeName(String empName);
	Employee add(Employee emp);
	Employee save(Employee emp);
	void deleteById(int empId);

}
