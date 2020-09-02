package com.sapient.week2.IncomeCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PersonImpl {
	List<Person> personList;

	public PersonImpl() {
		super();
		personList = new ArrayList<Person>();
	}

	public void readData(String path) {
		Path pathToFile = Paths.get(path);
		// create an instance of BufferedReader
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the first line from the text file
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				// use string.split to load a string array with the values from
				// each line of the
				// file
				// String[] attributes = line.split(DELIMITER, -1);
				String[] attributes = line.split(",", -1);
				Person person = createPerson(attributes);
				// adding book into ArrayList
				personList.add(person);
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Person createPerson(String[] attributes) {
		// System.out.println(attributes.length);
		String city = attributes[0]; // city
		String country = attributes[1]; // country
		if (country.isEmpty()) {
			country = city;
		}
		String gender = attributes[2]; // gender
		String currency = attributes[3]; // currency
		Double income = Double.parseDouble(attributes[4]); // average income
		if (!currency.equals("USD")) {
			income = convertToUSD(currency, income);
		}

		// create and return book of this metadata
		return new Person(country, gender, income);

	}

	public void printList() {
		for (Person p : personList) {
			System.out.println(p);
		}
	}

	private Double convertToUSD(String currency, Double income) {
		if (currency.equals("INR")) {
			// 1 INR= 0.015 USD
			income *= 0.015;
		} else if (currency.equals("HKD")) {
			// 1 HKD= 0.125 USD
			income *= 0.125;
		} else if (currency.equals("SGP")) {
			// 1 SGD= 0.667 USD
			income *= 0.667;
		} else if (currency.equals("GBP")) {
			// 1 GBP= 1.492 USD
			income *= 1.492;
		}
		return income;
	}

	public void writeData(String string) {
		Map<String, List<Person>> personCustomList = new HashMap<>();
		// personCustomList=

		personCustomList=personList.stream().collect(Collectors.groupingBy(Person::getCountry));
		
		System.out.println("Person grouped by country: " + personCustomList);
		
		// personCustomList=personList.stream().collect(Collectors.groupingBy(per->per.))
	}

}
