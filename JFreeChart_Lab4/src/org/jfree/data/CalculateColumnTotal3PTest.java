package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class CalculateColumnTotal3PTest {
	private static final double DELTA = .000000001d;
	private DefaultKeyedValues2D values;

	private void valuesGenerate(int row, int col) {
		double counter = 1.0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				values.addValue(counter++, "r" + Integer.toString(i), "c" + Integer.toString(j));
			}
		}
	}

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		values = new DefaultKeyedValues2D();
		System.out.println("Start " + testName.getMethodName());
	}
	
	@Test
	public void calculateColumnTotalForEmptyTable() {
		valuesGenerate(0, 0);
		int[] validRows = { 0 };
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, 0,validRows), DELTA);
	}

	@Test
	public void calculateColumnTotalForSingleColumn() {
		valuesGenerate(2, 1);
		int[] validRows = {0,1};
		assertEquals(3.0, DataUtilities.calculateColumnTotal(values, 0,validRows), DELTA);
	}

	@Test
	public void calculateColumnTotalForMultipleColumn() {
		valuesGenerate(3, 8);
		int[] validRows = {0,1,2};
		assertEquals(27.0, DataUtilities.calculateColumnTotal(values, 0,validRows), DELTA);
	}
	
	@Test
	public void calculateColumnTotalForNullTable() throws IllegalArgumentException {
		values.addValue(null, "r" + "0", "c" + "0");
		int[] validRows = {0};
		DataUtilities.calculateColumnTotal(values, 0,validRows);
	}

	@After
	public void tearDown() throws Exception {
		values = null;
		assertNull(values);
		System.out.println("End " + testName.getMethodName());
	}
}
