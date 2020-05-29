package com.evleen.junit5;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee {
	List<Employee> list = new ArrayList<>();
	public void addEmployee(Employee emp) {
		if(emp==null) {
			throw new IllegalArgumentException();
		}
		list.add(emp);
	}
	public Employee getEmployee(int id) {
		for(Employee emp: list) {
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;
	}
}
