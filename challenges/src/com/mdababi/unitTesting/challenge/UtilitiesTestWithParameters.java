package com.mdababi.unitTesting.challenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilitiesTestWithParameters {
	private Utilities utilities;
	private String input;
	private String output;
	
	public UtilitiesTestWithParameters(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Before
	public void setup() {
		utilities = new Utilities();
	}
	
	@Parameters
	public static Collection<Object[]> parameters(){
		return Arrays.asList(new Object[][] {
			{"ABCDEFF","ABCDEF"},
			{"AB88EFFG","AB8EFG"},
			{"1122334455667788","12345678"},
			{"ZYZQQB","ZYZQB"},
			{"A","A"}
		});
	}

	@Test
	public void testRemovePairsWithParameters() {
		assertEquals(output, utilities.removePairs(input));
	}

}
