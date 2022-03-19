package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Random;
import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class createNumberArrayTest extends DataUtilities {
	private static final double DELTA = .000000001d;
	private static final int MAX_INT = 100000000;
	private Random rand;

	@Before
	public void setUp() throws Exception {
		rand = new Random();
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void createNumberArrayTestForEmpty() {
		double[] d = new double[] {};
		Number[] n = DataUtilities.createNumberArray(d);
		assertEquals(d.length, n.length);
		for (int i = 0; i < d.length; i++) {
			assertEquals(d[i], n[i]);
		}
	}
	
	@Test
	public void createNumberArrayTestForDouble() {
		double[] d = new double[] { rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(),
				rand.nextDouble() };
		Number[] n = DataUtilities.createNumberArray(d);
		assertEquals(d.length, n.length, DELTA);
		for (int i = 0; i < d.length; i++) {
			assertEquals(d[i], (double) n[i], DELTA);
		}
	}


}
