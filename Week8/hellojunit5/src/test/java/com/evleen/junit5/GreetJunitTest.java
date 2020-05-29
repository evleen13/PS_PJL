package com.evleen.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class GreetJunitTest {
	private Greeting greeting;
	@Before
	public void setup() {
		greeting = new GreetJunit();
		
	}
	@Test
	void greetShouldReturnValidOutput() {
		String result = greeting.greet("Junit");
		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}
	
	@After
	public void tearDown() {
		greeting=null;
	}
}
