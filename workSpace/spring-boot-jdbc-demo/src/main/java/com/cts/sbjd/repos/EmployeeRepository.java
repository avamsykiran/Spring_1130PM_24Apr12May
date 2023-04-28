package com.cts.sbjd.repos;

import java.util.List;

import com.cts.sbjd.model.Employee;

public interface EmployeeRepository {
	
	List<Employee> findAll();
	Employee findById(int empId);
	Employee add(Employee emp);
	Employee save(Employee emp);
	void deleteById(int empId);

}
