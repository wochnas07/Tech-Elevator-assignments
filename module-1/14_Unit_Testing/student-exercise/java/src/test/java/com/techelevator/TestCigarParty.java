package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCigarParty {

CigarParty testCode = new CigarParty();


@Test 

public void test_correct_succcessful_parties_based_on_parties_with_cigars() {
	
	assertEquals("Party was unsuccessful.", true, testCode.haveParty(60, false));
	assertEquals("Party was unsuccessful.", true, testCode.haveParty(40, false));
	assertEquals("Party was unsuccessful.", true, testCode.haveParty(40, true));
	assertEquals("Party was unsuccessful.", true, testCode.haveParty(80, true));
	assertEquals("Party was unsuccessful.", false, testCode.haveParty(20, false));
	assertEquals("Party was unsuccessful.", false, testCode.haveParty(80, false));
	assertEquals("Party was unsuccessful.", false, testCode.haveParty(20, true));
}

}
