package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

public class ShiftTest extends Range {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShiftTest() {
		// TODO Auto-generated constructor stub
		super(1.00, 1.00);
	}

	private Range testRange, resultRange;
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		testRange = new Range(5.00, 10.50);
		System.out.println("Start " + testName.getMethodName());
	}
	
	//Test Case 1: delta > 0
	@Test
	public void ShiftPositive() {
		resultRange = new Range(9.56, 15.06);
		assertNotEquals(resultRange, Range.shift(testRange, 4.56));
	}
	
	//Test Case 2: delta < 0
	@Test
	public void ShiftNegative() {
		resultRange = new Range(-2.35, 3.15);
		assertNotEquals(resultRange, Range.shift(testRange, -7.35));
	}
	
	//Test Case 3: delta = 0
	@Test
	public void ShiftZero() {
		resultRange = new Range(5.00, 10.50);
		assertEquals(resultRange, Range.shift(testRange, 0));
		
		Range a = new Range (-10.0,10.0);
		assertEquals(new Range(0.0,25), Range.shift(a, 15));
		Range b = new Range (0,0);
		assertEquals(new Range(15,15), Range.shift(b, 15));
		
		Range c = new Range (10,15);
		assertEquals(new Range(0.5,5.5), Range.shift(c, -9.5));
		
		Range d = new Range (10,15);
		assertEquals(new Range(0,3.5), Range.shift(d, -11.5));
		
		Range e = new Range (0.5,15);
		assertEquals(new Range(0,14), Range.shift(e, -1));
		
		Range f = new Range (-0.5,15);
		assertEquals(new Range(0,16), Range.shift(f, 1));
		
		Range g = new Range (-0.5,15);
		assertEquals(new Range(0,16), Range.shift(g, 1));
		
		

		
	}
	
	
	
	@Test
	public void shiftWithZeroCrossing() {
		boolean zeroCrossing = true;
		testRange = new Range(-20.0, 20.0);
		resultRange = new Range(-20.0, 20.0);
		assertEquals(resultRange, Range.shift(testRange, 0, zeroCrossing));
	}
	
	@After
	public void tearDown() throws Exception {
		resultRange = null;
		assertNull(resultRange);
		System.out.println("End " + testName.getMethodName());
	}

}
