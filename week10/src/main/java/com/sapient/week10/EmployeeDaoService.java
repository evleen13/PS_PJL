package com.sapient.week10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoService {
	private static List<Employee> employees = new ArrayList<>();
	private static int employeeCount = 3;
	static {
		employees.add(new Employee(1, "Eve", new Date()));
		employees.add(new Employee(2, "Jack", new Date()));
		employees.add(new Employee(3, "lol", new Date()));
	}

	public List<Employee> findAll() {
		return employees;
	}

	public Employee save(Employee employee) {
		if (employee.getId() == 0) {
			employee.setId(++employeeCount);
		}
		employees.add(employee);
		return employee;
	}

	public Employee findOne(int id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	public Employee findByName(String name) {
		for (Employee employee : employees) {
			if ((employee.getName()).equals(name)) {
				return employee;
			}
		}
		return null;
	}

	public void delete(int id) {

		for (Employee e : employees) {
			if (e.getId() == id) {

				e = null;
				break;
			}
		}
	}

	public void modify(int id, Employee employee) {

		for (Employee e : employees) {
			if (e.getId() == id) {

				e.setName(employee.getName());
				e.setBirthDate(employee.getBirthDate());
				break;
			}
		}
	}
}
