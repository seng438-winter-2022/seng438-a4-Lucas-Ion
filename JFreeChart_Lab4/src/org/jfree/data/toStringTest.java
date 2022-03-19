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

public class toStringTest extends Range {
	
	private Range exampleRange;
	
	public toStringTest() {
		super(1.23, 4.56);
	}

	@Rule
	public TestName test = new TestName();

	@Before
    public void setUp() throws Exception { 
		System.out.println("Start " + test.getMethodName());
    }

    @Test
    public void rangeToString() {
        exampleRange = new Range(-20.0, 20.0);
        String expected = "Range[-20.0,20.0]";
        assertEquals(expected, exampleRange.toString());
    }
    
    @After
    public void tearDown() throws Exception {
		System.out.println("End " + test.getMethodName());
    }
}