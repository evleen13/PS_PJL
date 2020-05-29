package com.evleen.junit5;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	public Employee setup() {

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("evleen");
		emp.setCity("pune");

		return emp;
	}

	@Test
	public void test() {
		AddEmployee emp = new AddEmployee();
		emp.addEmployee(setup());
		Employee actual= emp.getEmployee(1);
		assertEquals("evleen", actual.getName());
	}
	
}
