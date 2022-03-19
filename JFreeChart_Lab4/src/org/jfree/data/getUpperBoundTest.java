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

public class getUpperBoundTest extends Range {
	
	private Range exampleRange;
	
	public getUpperBoundTest() {
		super(1.23, 4.56);
	}

	@Rule
	public TestName test = new TestName();

	@Before
    public void setUp() throws Exception { 
		System.out.println("Start " + test.getMethodName());
    }

    @Test
    public void negativeUpperBound() {
        exampleRange = new Range(-2.02, -1.01);
        assertEquals(-1.01, exampleRange.getUpperBound(), 000000001d);
    }
    
    @Test
    public void positiveUpperBound() {
        exampleRange = new Range(0, 1.01);
        assertEquals(1.01, exampleRange.getUpperBound(), 000000001d);
    }
    
    @Test
    public void getUpperBoundWithSameBounds() {
        exampleRange = new Range(1.01, 1.01);
        assertEquals(1.01, exampleRange.getUpperBound(), 000000001d);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalBounds() throws IllegalArgumentException {
        exampleRange = new Range(1.01, -1.01);
        assertEquals(1.01, exampleRange.getUpperBound(), 000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
		System.out.println("End " + test.getMethodName());
    }
}