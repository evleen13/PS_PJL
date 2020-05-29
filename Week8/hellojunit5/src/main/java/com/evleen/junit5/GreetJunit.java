package com.evleen.junit5;


public class GreetJunit implements Greeting{

	@Override
	public String greet(String name) {
		if(name == null || name.length()==0) {
			throw new IllegalArgumentException();
		}
		return "Hello "+ name;
	}
	
}
