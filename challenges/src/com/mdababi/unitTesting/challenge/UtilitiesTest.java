package com.mdababi.unitTesting.challenge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {
	private Utilities utilities;

	@Before
	public void setup() {
		utilities = new Utilities();
	}
	
	@Test
	public void testEveryNthChar() {
		char[] source = new char[] { 'h', 'e', 'l', 'l', 'o' };
		assertArrayEquals(new char[] { 'e', 'l' }, utilities.everyNthChar(source, 2));
		assertNull(utilities.everyNthChar(null, 5));
		assertEquals(source, utilities.everyNthChar(source, 7));
	}

	@Test
	public void testRemovePairs() {
		assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
		assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
		assertNull(utilities.removePairs(null));
		assertEquals("A", utilities.removePairs("A"));
		assertEquals("ABCDEF", utilities.removePairs("ABBBCDEF"));
	}
	
	@Test
	public void testConverter() {
		assertEquals(300, utilities.converter(10, 5));
	}

	@Test(expected = ArithmeticException.class)
	public void testConverterWithException() {
		assertEquals(300, utilities.converter(10, 0));
	}

	@Test
	public void testNullIfOddLength() {
		assertEquals("azerty", utilities.nullIfOddLength("azerty"));
		assertNull(utilities.nullIfOddLength("aze"));
	}

}
