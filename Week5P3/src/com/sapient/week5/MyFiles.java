package com.sapient.week5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class MyFiles {

	private static void displayFiles(String path) throws IOException {
		// Predicate<? super Path> predicate= (s) ->
		// String.valueOf(s).contains(".java");
		// TODO Auto-generated method stub
		// Files.list(Paths.get(".")).forEach(System.out::println);
		// Files.walk(Paths.get("."), 1).filter(predicate).forEach(System.out::println);
		BiPredicate<Path, BasicFileAttributes> matcher = (paths, attr) -> attr.isRegularFile();
		Files.find(Paths.get(path), 1, matcher).forEach(System.out::println);
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file path");
		String path = scanner.next();
		displayFiles(path);
		scanner.close();
	}

}
