package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class expandTest extends Range {
	
	private Range exampleRange, result;
	
	public expandTest() {
		super(1.23, 4.56);
	}

	@Rule
	public TestName test = new TestName();

	@Before
    public void setUp() throws Exception { 
		System.out.println("Start " + test.getMethodName());
    }

    @Test
    public void upperMarginTest() {
        exampleRange = new Range(-1.0, 1.0);
        result = new Range(-1.0, 2.0);
        assertEquals(result, Range.expand(exampleRange, 0, 0.5));
    }
    
    @Test
    public void lowerMarginTest() {
    	 exampleRange = new Range(-1.0, 1.0);
         result = new Range(-2.0, 1.0);
         assertEquals(result, Range.expand(exampleRange, 0.5, 0));
    }
    
    @Test
    // Range = (-1.0,1.0)
    // lower = -1.0 - (2*-1.0) = 1.0
    // upper = 1.0 - (2*-1.0) = -1.0
    
    public void lowerMarginGreater() {
        exampleRange = new Range(-1.0, 1.0);
        result = new Range(0,0);
        assertEquals(result, Range.expand(exampleRange, -1, -1));
    }
    
    @Test
    // -1 - (2-1) = 1
    // 1 + (20) = 1
    public void upperGreaterEqualtoLower( ) {
        exampleRange = new Range(3, 5);
        result = new Range(4,4);
        assertEquals(result, Range.expand(exampleRange, -1, -1));
    }

    @After
    public void tearDown() throws Exception {
		System.out.println("End " + test.getMethodName());
    }
}