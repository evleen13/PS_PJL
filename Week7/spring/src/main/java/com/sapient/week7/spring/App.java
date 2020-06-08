package com.sapient.week7.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
		Company company = (Company) factory.getBean("company");
		Employee[] emp = company.getEmployeeArray();
		System.out.println(" Using XML container\n\nEnter Employee id: ");
		int id = sc.nextInt();
		System.out.println(emp[id - 1].getId() + " " + emp[id - 1].getName() + " " + emp[id - 1].getCity());
		//Employee object = (Employee) factory.getBean("employee");
		//System.out.println("Hello World!");
		factory = new AnnotationConfigApplicationContext(JavaContainer.class);
		company = factory.getBean(Company.class);

		emp = company.getEmployeeArray();
		System.out.println("Using Java container\n\nEnter Employee id: ");
		id = sc.nextInt();
		System.out.println(emp[id - 1].getId() + " " + emp[id - 1].getName() + " " + emp[id - 1].getCity());
		sc.close();
	}
}
