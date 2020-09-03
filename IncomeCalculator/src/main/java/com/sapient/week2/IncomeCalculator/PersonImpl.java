package com.sapient.week2.IncomeCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

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
			income /= 66;
		} else if (currency.equals("HKD")) {
			// 1 HKD= 0.125 USD
			income /= 8;
		} else if (currency.equals("SGP")) {
			// 1 SGD= 0.667 USD
			income /= 1.5;
		} else if (currency.equals("GBP")) {
			// 1 GBP= 1.492 USD
			income /= 0.67;
		}
		return income;
	}

	public void processAndWriteToCSV(String string) {

		/*
		 * personList.stream() .collect(Collectors.groupingBy(Person::getCountry,
		 * Collectors.summingDouble(Person::getIncome))) .forEach((country, income) ->
		 * System.out.println(country + "\t" + income));
		 */

		List<Person> groupedList = new ArrayList<Person>();
		// grouping by country and gender thereby summing average income
		personList.stream()
				.collect(Collectors.groupingBy(Person::getCountry,
						Collectors.groupingBy(Person::getGender, Collectors.summingDouble(Person::getIncome))))
				.forEach((String country, Map<String, Double> d) -> {
					for (Entry<String, Double> entry : d.entrySet()) {
						String k = entry.getKey();
						Double v = entry.getValue();
						groupedList.add(new Person(country, k, v));
					}
				});
		Comparator<Person> countryComparator = new Comparator<Person>() {

			public int compare(Person p1, Person p2) {
				String country1 = p1.getCountry();
				String country2 = p2.getCountry();

				// ascending order
				return country1.compareTo(country2);

			}
		};
		Comparator<Person> genderComparator = new Comparator<Person>() {

			public int compare(Person p1, Person p2) {
				String gender1 = p1.getGender();
				String gender2 = p2.getGender();

				// ascending order
				return gender1.compareTo(gender2);

			}
		};
		Collections.sort(groupedList, countryComparator.thenComparing(genderComparator));
		System.out.println(groupedList);
		writeDataToCSV(string, groupedList);
	}

	private void writeDataToCSV(String string, List<Person> groupedList) {
		File file = new File(string);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = { "Country", "Gender", "Average Income" };
			writer.writeNext(header);
			for (Person p : groupedList) {
				String country = p.getCountry();
				String gender= p.getGender();
				String income= Double.toString(p.getIncome()) ;
				String [] data= {country,gender,income};
				writer.writeNext(data);
 			}
			// add data to csv
			
			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
