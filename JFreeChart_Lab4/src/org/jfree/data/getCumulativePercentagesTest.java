package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class getCumulativePercentagesTest {
	private DefaultKeyedValues values;
	private DefaultKeyedValues result;

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		values = new DefaultKeyedValues();
		result = new DefaultKeyedValues();
		for (int i = 0; i < 5; i++) {
			values.addValue(Integer.toString(i), (double) i);
		}
		for (int i = 0; i < 5; i++) {
			result.addValue(Integer.toString(i), ((double) 10 - i)/ (double) 10);
		}
		System.out.println("Start " + testName.getMethodName());
	}

	@Test
	public void testWithValidValues() {
		KeyedValues ToReturn = DataUtilities.getCumulativePercentages(values);
		for(int i = 0; i < ToReturn.getItemCount(); i++) {
			assertEquals(result.getKey(i), ToReturn.getKey(i));
		}
	}
	
	@Test
	public void test1() {
		DefaultKeyedValues a = new DefaultKeyedValues();
		a.addValue("0", 1);
		KeyedValues ToReturn = DataUtilities.getCumulativePercentages(a);
		System.out.println(ToReturn.getIndex("0"));
		assertEquals(1.0, ToReturn.getValue(0));
	}
	
	@Test
	public void test2() {
		DefaultKeyedValues a = new DefaultKeyedValues();
		a.addValue("0", 1);
		a.addValue("1", 2);
		KeyedValues ToReturn = DataUtilities.getCumulativePercentages(a);
		System.out.println(ToReturn.getValue(0));
		double result1 = 0.3333333333333333;
		System.out.println(result1);
		assertEquals(result1, ToReturn.getValue(0));
		assertEquals(1.0, ToReturn.getValue(1));
	}
	
	
	@Test
	public void testWithNullValues() {
		DefaultKeyedValues emptyValues = new DefaultKeyedValues();
		emptyValues.addValue("0", null);
		KeyedValues ToReturn = DataUtilities.getCumulativePercentages(emptyValues);
		for(int i = 0; i < ToReturn.getItemCount(); i++) {
			assertEquals(Double.NaN, ToReturn.getValue(i));
		}
	}
}
