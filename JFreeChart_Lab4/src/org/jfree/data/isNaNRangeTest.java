package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class isNaNRangeTest {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		System.out.println("Start " + testName.getMethodName());
	}

	@Test
	public void isNaNRangeAllCases() {
		Range a = new Range(Double.NaN, 2);
		assertFalse(a.isNaNRange());

		Range b = new Range(2, Double.NaN);
		assertFalse(b.isNaNRange());

		Range c = new Range(Double.NaN, Double.NaN);
		assertTrue(c.isNaNRange());

		Range d = new Range(2, 3);
		assertFalse(d.isNaNRange());
	}
}
