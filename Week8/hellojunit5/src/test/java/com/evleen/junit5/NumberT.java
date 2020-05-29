package com.evleen.junit5;



import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class NumberT {

	@Test
	public void checkPrimeTest() {
		Number number = new Number();
		assertEquals(1, number.checkPrime(17));
		assertEquals(0, number.checkPrime(16));
	}

	@Test
	public void checkArmStrongTest() {
		Number number = new Number();
		assertTrue(number.checkArmstrong(1634));
	}
	@Test
	public void checkPalindromeTest() {
		Number number = new Number();
		assertTrue(number.checkPalindrome(111));
	}
}
