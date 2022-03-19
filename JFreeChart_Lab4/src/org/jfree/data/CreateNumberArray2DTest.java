package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Random;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArray2DTest extends DataUtilities {
	private static final double DELTA = .000000001d;
	private static final int MAX_INT = 10000;
	private Random rand;

	@Before
	public void setUp() throws Exception {
		rand = new Random();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CreateNumberArray2DTestForEmpty() {
		double[][] d = new double[][] {};
		Number[][] n = DataUtilities.createNumberArray2D(d);
		assertEquals(d.length, n.length);
		for (int i = 0; i < d.length; i++) {
			assertEquals(d[i].length, n[i].length);
			for (int j = 0; j < d[i].length; j++)
				assertEquals(d[i][j], n[i][j]);
		}
	}

	@Test
	public void CreateNumberArray2DTestForDouble() {
		double[][] d = new double[][] {
				{ rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble() },
				{ rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(),
						rand.nextDouble() } };
		Number[][] n = DataUtilities.createNumberArray2D(d);
		assertEquals(d.length, n.length, DELTA);
		for (int i = 0; i < d.length; i++) {
			assertEquals(d[i].length, n[i].length);
			for (int j = 0; j < d[i].length; j++)
				assertEquals(d[i][j], n[i][j]);
		}
	}


}