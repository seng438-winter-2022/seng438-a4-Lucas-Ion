package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class combineIgnoringNANTest {

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		System.out.println("Start " + testName.getMethodName());
	}

	@Test
	public void withRangeOneIsNull() {
		Range range1 = null;
		Range range2 = new Range(1, 2);
		assertEquals(range2, Range.combineIgnoringNaN(range1, range2));

		range2 = new Range(Double.NaN, Double.NaN);
		assertEquals(null, Range.combineIgnoringNaN(range1, range2));
		
		range2 = null;
		assertEquals(range2, Range.combineIgnoringNaN(range1, range2));
		
	}

	@Test
	public void withRangeTwoIsNull() {
		Range range2 = null;
		Range range1 = new Range(1, 2);
		assertEquals(range1, Range.combineIgnoringNaN(range1, range2));

		range1 = new Range(Double.NaN, Double.NaN);
		assertEquals(null, Range.combineIgnoringNaN(range1, range2));
	}

	@Test
	public void withValidRange() {
		Range range1 = new Range(0, 2);
		Range range2 = new Range(1, 2);
		assertEquals(new Range(0, 2), Range.combineIgnoringNaN(range1, range2));
	}

	@Test
	public void withPartialValidRange() {
		Range range1 = new Range(Double.NaN, Double.NaN);
		Range range2 = new Range(Double.NaN, Double.NaN);
		assertEquals(null, Range.combineIgnoringNaN(range1, range2));

		range2 = new Range(Double.NaN, 2);
		Range range3 = Range.combineIgnoringNaN(range1,range2);
		double lowerR = range3.getLowerBound();
		double upperR = range3.getUpperBound();
		assertTrue(Double.isNaN(lowerR));
		assertEquals(0,Double.compare(2.0, upperR));
		
		range1 = new Range(2, Double.NaN);
		range2 = new Range(Double.NaN, Double.NaN);
		range3 = Range.combineIgnoringNaN(range1,range2);
		lowerR = range3.getLowerBound();
		upperR = range3.getUpperBound();
		assertTrue(Double.isNaN(upperR));
		assertEquals(0,Double.compare(2.0, lowerR));
		
		range1 = new Range(Double.NaN, 2);
		range2 = new Range(Double.NaN, Double.NaN);
		range3 = Range.combineIgnoringNaN(range1,range2);
		lowerR = range3.getLowerBound();
		upperR = range3.getUpperBound();
		assertTrue(Double.isNaN(lowerR));
		assertEquals(0,Double.compare(2.0, upperR));
	}

}
