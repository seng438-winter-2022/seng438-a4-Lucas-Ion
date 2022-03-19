package org.jfree.data;
import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class CalculateRowTotalTest extends DataUtilities {
	private static final double DELTA = .000000001d;
	private DefaultKeyedValues2D table;
	
	@Rule
    public TestName testName = new TestName();

	private void tableGenerate(int row, int col) {
		double counter = 1.0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				table.addValue(counter++, "r" + Integer.toString(i), "c" + Integer.toString(j));
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		table = new DefaultKeyedValues2D();
		System.out.println("Start " + testName.getMethodName());
	}
	
	@Test
	public void calculateRowTotalForEmptyTable() {
		tableGenerate(0,0);
		assertEquals(0.0, DataUtilities.calculateRowTotal(table, 0), DELTA);
	}

	@Test
	public void calculateRowTotalForSingleRow() {
		tableGenerate(1,4);
		assertEquals(10.0, DataUtilities.calculateRowTotal(table, 0), DELTA);
	}

	@Test
	public void calculateRowTotalForMultipleRow() {
		tableGenerate(3,8);
		assertEquals(36.0, DataUtilities.calculateRowTotal(table, 0), DELTA);
	}

	@Test
	public void calculateRowTotalForNullTable() throws IllegalArgumentException {
		table.addValue(null, "r" + "0", "c" + "0");
		DataUtilities.calculateRowTotal(table, 0);
	}

	@After
	public void tearDown() throws Exception {
		table = null;
		assertNull(table);
		System.out.println("End " + testName.getMethodName());
	}

}
