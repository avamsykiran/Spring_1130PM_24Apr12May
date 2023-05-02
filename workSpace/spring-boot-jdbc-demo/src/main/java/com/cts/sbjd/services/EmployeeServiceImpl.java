package com.cts.sbjd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbjd.model.Employee;
import com.cts.sbjd.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int empId) {
		return empRepo.findById(empId);
	}

	@Override
	public Employee add(Employee emp) {
		return empRepo.add(emp);
	}

	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public void deleteById(int empId) {
		empRepo.deleteById(empId);
	}

}
