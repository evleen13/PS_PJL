package com.sapient.week5;

public class MyThreadRunner {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {

			Task1 task1 = new Task1();
			Thread task1Thread = new Thread(task1);

			Task2 task2 = new Task2();
			task1Thread.start();
			task1Thread.join();
			task2.start();
		}

	}

}
