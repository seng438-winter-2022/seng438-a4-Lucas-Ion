package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

public class equalTest {
	
	@Rule
	public TestName testName = new TestName();
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Start " + testName.getMethodName());
	}
	
	@Test
	public void equalWithNullValues() {
		double [][] a = null;
		double [][] b = null;
		assertEquals(true, DataUtilities.equal(a,b));
		double [][] c = {{2.0,4.4}};
		assertEquals(false, DataUtilities.equal(c,b));
		assertEquals(false, DataUtilities.equal(b,c));
	}
	
	@Test
	public void equalWithDifferentLength() {
		double [][] a = {{2.0,4.4},{2.0}};
		double [][] b = {{2.0,4.4}};
		assertEquals(false, DataUtilities.equal(a,b));
		double [][] c = {{2.0,4.0},{2.0}};
		double [][] d = {{2.0},{2.0}};
		assertEquals(false, DataUtilities.equal(c,d));
	}
	
	@Test
	public void equalWithValidValues() {
		double [][] a = {{2.0,4.4},{2.0}};
		double [][] b = {{2.0,4.4},{2.0}};
		assertEquals(true, DataUtilities.equal(a,b));
		
		double [][] c = {{2.0,4.4},{2.0}};
		double [][] d = {{2.0},{2.0}};
		assertEquals(false, DataUtilities.equal(c,d));
		
		
	}
	
	@Test
	public void equalWithException() {
		double [][] a = null;
		double [][] b = {{Double.NaN,Double.NaN}};
		exceptionRule.expect(NullPointerException.class);
	    DataUtilities.equal(a,b);
	}

}
