package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
public class hashCodeTest {
	private Range range1;
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		range1 = new Range(1,2);
		System.out.println("Start " + testName.getMethodName());
	}
	
	@Test
	public void hashCodeTesting() {
		assertEquals(2117074944, range1.hashCode());
	}
	
	
	
}
