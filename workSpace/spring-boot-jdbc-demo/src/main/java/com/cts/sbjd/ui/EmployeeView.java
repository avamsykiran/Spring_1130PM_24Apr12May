package com.cts.sbjd.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbjd.model.Employee;
import com.cts.sbjd.services.EmployeeService;

enum Menu{
	LIST,ADD,DELETE,QUIT
}

@Component
public class EmployeeView implements CommandLineRunner {

	@Autowired
	private Scanner kbin;
	
	@Autowired
	private EmployeeService empService;
	
	@Override
	public void run(String... args) throws Exception {
		String options = Arrays.stream(Menu.values()).map(Menu::toString).reduce((s1,s2) -> s1+","+s2).orElse("");
		Menu menu = null;
		
		while(menu!=Menu.QUIT) {
			System.out.print(options);
			System.out.print("\tOption? ");
			String option = kbin.next().toUpperCase();
			
			if(options.indexOf(option) == -1) {
				System.out.println("Invalid option");
				continue;
			}
			
			menu = Menu.valueOf(option);
			
			switch (menu) {
			case LIST:doList();break;
			case ADD:doAdd();break;
			case DELETE:doDelete();break;
			case QUIT: System.out.println("Thanq See you again!"); break;
			}
		}
		
	}

	private void doList() {
		List<Employee> emps = empService.findAll();
		
		if(emps==null || emps.isEmpty()) {
			System.out.println("No records as of now!");
		}else {
			emps.stream().forEach(System.out::println);
		}
	}
	
	private void doAdd() {
		Employee emp = new Employee();
		
		System.out.print("Name: ");
		emp.setEmpName(kbin.next());
		System.out.print("Salary: ");
		emp.setSalary(kbin.nextDouble());
		
		empService.add(emp);
		System.out.println("Record Saved!");
	}
	
	private void doDelete() {
		System.out.print("Employee Id to be deleted? ");
		int empId = kbin.nextInt();
		
		empService.deleteById(empId);
		System.out.println("Record Deleted");
	}
}
