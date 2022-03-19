package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

public class LengthTest extends Range {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LengthTest() {
		// TODO Auto-generated constructor stub
		super(1.00, 1.00);
	}

	private static final double DELTA = .000000001d;
	private Range testRange;
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		System.out.println("Start " + testName.getMethodName());
	}
	
	//Test Case 1: upperBound > 0, lowerBound > 0
	@Test
	public void testCasePositive() {
		testRange = new Range(3.00, 6.00);
		assertEquals(3.00, testRange.getLength(), DELTA);
	}
	
	//Test Case 2: upperBound < 0, lowerBound < 0
	@Test
	public void testCaseNegative() {
		testRange = new Range(-8.45, -3.00);
		assertEquals(5.45, testRange.getLength(), DELTA);
	}
	
	//Test Case 3: upperBound > 0, lowerBound < 0
	@Test
	public void testCasePosiNegi() {
		testRange = new Range(-8.67, 3.45);
		assertEquals(12.12, testRange.getLength(), DELTA);
	}
	
	//Test Case 4: Expected Error since upperBound < lowerBound
	@Test(expected = IllegalArgumentException.class)
    public void testCaseError() throws IllegalArgumentException{
        testRange = new Range(8.67, 3.45);
        assertEquals(5.22, testRange.getLength(), DELTA);
    }

	@After
	public void tearDown() throws Exception {
		testRange = null;
		assertNull(testRange);
		System.out.println("End " + testName.getMethodName());
	}

}
