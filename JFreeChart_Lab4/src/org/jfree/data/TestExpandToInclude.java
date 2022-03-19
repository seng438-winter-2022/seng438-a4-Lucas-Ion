package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestExpandToInclude {

	private Range testRange, resultRange;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testExpandToIncludeNullRange() {
		resultRange = new Range(10, 10);
		assertEquals("Since testRange is null, result range should have both upper and lower bounds to be 10",
				resultRange, Range.expandToInclude(testRange, 10));
	}
	
	@Test
	public void testExpandToIncludeLowerBound() {
		testRange = new Range(10, 20);
		resultRange = new Range(5, 20);
		assertEquals("Since the value is less than lower bound, the range will be (5, 20)",
				resultRange, Range.expandToInclude(testRange, 5));
	}
	
	@Test
	public void testExpandToIncludeUpperBound() {
		testRange = new Range(10, 20);
		resultRange = new Range(10, 30);
		assertEquals("Since the value is greater than upper bound, the range will be (10, 30)",
				resultRange, Range.expandToInclude(testRange, 30));
	}
	
	@Test
	public void testExpandToIncludeEqualValue() {
		testRange = new Range(10, 20);
		resultRange = new Range(10, 20);
		assertEquals("Since the value is the lower bound, the range will stay the same",
				resultRange, Range.expandToInclude(testRange, 10));
	}

	@After
	public void tearDown() throws Exception {
		testRange = null;
		assertNull(testRange);
		resultRange = null;
		assertNull(resultRange);
	}

}
