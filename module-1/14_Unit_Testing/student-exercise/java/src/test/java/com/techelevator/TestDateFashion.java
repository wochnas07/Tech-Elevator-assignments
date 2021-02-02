package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDateFashion {
	
DateFashion testCode = new DateFashion();


	@Test
	
	public void test_if_you_getTable_based_on_fashion() {
		
		assertEquals("You do not get a table.", 2, testCode.getATable(5, 10));
		assertEquals("You do not get a table.", 2, testCode.getATable(10, 5));
		assertEquals("You do not get a table.", 2, testCode.getATable(8, 8));
		assertEquals("You do not get a table.", 1, testCode.getATable(5, 5));
		assertEquals("You do not get a table.", 0, testCode.getATable(2, 2));
		assertEquals("You do not get a table.", 0, testCode.getATable(5, 2));
		assertEquals("You do not get a table.", 0, testCode.getATable(10, 1));
		assertEquals("You do not get a table.", 0, testCode.getATable(1, 10));
	}

}
