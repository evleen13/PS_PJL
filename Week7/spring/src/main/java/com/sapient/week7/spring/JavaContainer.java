package com.sapient.week7.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaContainer {
	@Bean
	public Company f2() {
		
		Company company = new Company();
		
		Employee[] emp = new Employee[3];
		
		emp[0] = new Employee();
		emp[1] = new Employee();
		emp[2] = new Employee();
		emp[0].setId(1); emp[0].setName("Evleen"); emp[0].setCity("pune");
		emp[1].setId(2); emp[1].setName("Raj"); emp[1].setCity("Delhi");
		emp[2].setId(3); emp[2].setName("Raju"); emp[2].setCity("pune");

		company.setEmployees(emp);
		return company;
		
		
	}
}
