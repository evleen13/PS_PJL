package com.sapient.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentRunner {

	public static void main(String[] args) throws StudentNotFound {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no. of student");
		int n = scanner.nextInt();
		Student[] student = new Student[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter id:");
			int id = scanner.nextInt();
			System.out.println("Enter Name:");
			String name = scanner.next();
			System.out.println("Enter City:");
			String city = scanner.next();
			student[i] = new Student(id, name, city);
		}
		for (int i = 0; i < student.length; i++) {

			student[i].display();
		}
		java.util.List<Student> list = new ArrayList<>();

		for (int i = 0; i < student.length; i++) {
			list.add(student[i]);
		}

		System.out.println("Enter the city:");
		String city = scanner.next();

		List<Student> commonCityList = displayStudentsfromParticularCity(list, city);

		System.out.println("Students that belong to " + city);
		displayList(commonCityList);

		System.out.println("Sort by Name");
		Collections.sort(list, new compareByName());

		displayList(list);

		System.out.println("Sort by City");
		Collections.sort(list, new compareByCity());

		displayList(list);
		int id = scanner.nextInt();
		findStudentById(list, id);
		scanner.close();

	}

	private static Student findStudentById(List<Student> list, int id) throws StudentNotFound {
		// TODO Auto-generated method stub

		for (Student student : list) {
			if (student.getId() == id) {
				return student;
			}
		}
		throw new StudentNotFound("Student with given id not found");

	}

	private static void displayList(List<Student> list) {
		for (Student st : list)
			System.out.println(st.getId() + " " + st.getName() + " " + st.getCity());
	}

	private static List<Student> displayStudentsfromParticularCity(List<Student> list, String city) {
		// TODO Auto-generated method stub
		List<Student> commonCityList = new ArrayList<Student>();
		for (Student student : list) {
			if (student.getCity() == city) {
				commonCityList.add(student);
			}
		}
		return commonCityList;
	}
}

class compareByName implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}

class compareByCity implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getCity().compareTo(o2.getCity());
	}
}