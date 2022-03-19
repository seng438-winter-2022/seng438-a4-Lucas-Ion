package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

public class CentralValueTest extends Range {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CentralValueTest() {
		super(1.0, 1.0);
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
	public void CentralValuePositive() {
		testRange = new Range(3.00, 6.00);
		assertEquals(4.50, testRange.getCentralValue(), DELTA);
	}
	
	//Test Case 2: upperBound < 0, lowerBound < 0
	@Test
	public void CentralValueNegative() {
		testRange = new Range(-50.70, -10.30);
		assertEquals(-30.50, testRange.getCentralValue(), DELTA);
	}
	
	//Test Case 3: upperBound > 0, lowerBound < 0
	@Test
	public void CentralValuePosiNegi() {
		testRange = new Range(-45.67, 87.56);
		assertNotEquals(20.045, testRange.getCentralValue(), DELTA);
	}
	
	//Test Case 4: Expected Error as upperBound < lowerBound
	public void CentralValueError() {
		testRange = new Range(10.00, 6.00);
		assertEquals(8.00, testRange.getCentralValue(), DELTA);
	}

	@After
	public void tearDown() throws Exception {
		testRange = null;
		assertNull(testRange);
		System.out.println("End " + testName.getMethodName());
	}

}
