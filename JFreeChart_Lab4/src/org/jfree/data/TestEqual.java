package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEqual {

	private Range rangeLHS, rangeRHS;
	
	@Before
	public void setUp() throws Exception {
		rangeLHS = new Range(10, 20);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualNotSameObject() {
		assertFalse("Cannot compare Range and int", rangeLHS.equals(10));
	}
	
	@Test
	public void testNotEqualLowerBound() {
		rangeRHS = new Range(20, 30);
		assertFalse("They are not equal", rangeLHS.equals(rangeRHS));
	}
	
	@Test
	public void testNotEqualUpperBound() {
		rangeRHS = new Range(10, 30);
		assertFalse("They are not equal", rangeLHS.equals(rangeRHS));
	}
	
	@Test
	public void testRangeEqual() {
		rangeRHS = new Range(10, 20);
		assertTrue("Both ranges are equal", rangeLHS.equals(rangeRHS));
		
	}

	@After
	public void tearDown() throws Exception {
		rangeRHS = null;
		assertNull(rangeRHS);
	}

	

}
