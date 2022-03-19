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

public class scaleTest extends Range {
	
	private Range exampleRange, result;
	
	public scaleTest() {
		super(1.23, 4.56);
	}

	@Rule
	public TestName test = new TestName();

	@Before
    public void setUp() throws Exception { 
		System.out.println("Start " + test.getMethodName());
    }

    @Test
    public void positiveFactor() {
        exampleRange = new Range(-20.0, 20.0);
        result = new Range(-40.0, 40.0);
        assertEquals(result, Range.scale(exampleRange, 2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactor() throws IllegalArgumentException{
        exampleRange = new Range(-20.0, 20.0);
        Range.scale(exampleRange, -0.5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeFactor() throws IllegalArgumentException{
    	exampleRange = new Range(-20.0, 20.0);
    	result = new Range(40.0,-40.0);
        Range.scale(exampleRange, -2);
    }
    
    @After
    public void tearDown() throws Exception {
		System.out.println("End " + test.getMethodName());
    }
}