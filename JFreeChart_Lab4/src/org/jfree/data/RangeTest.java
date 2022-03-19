package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range testRange, resultRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-20, 20);
    }
    
    @Test
    public void testGetLowerBound() {
    	assertEquals("The lower bound should be -20", 
    	-20, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testGetUpperBound() {
    	assertEquals("The upper bound should be 20", 
    	    	20, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void testGetLength() {
    	assertEquals("The length should be 40",
    			40, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -20 and 20 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void shouldContainThisValue() {
    	assertTrue("This range should contain 1", exampleRange.contains(1));
    	
    	assertTrue("This range should contain 20", exampleRange.contains(20));
    	
    	assertTrue("This range should contain -20", exampleRange.contains(-20));
    }
    
    @Test
    public void shouldNotContainThisValue() {
    	assertFalse("This range should not contain 30", exampleRange.contains(30));
    	
    }
    
    @Test
    public void shouldIntersectsTwoDoubles() {
    	assertTrue("This range should intersect with (-30, -10)", exampleRange.intersects(-30, -10));
    	assertFalse("This range should intersect with (-21, -20)", exampleRange.intersects(-20, -20));
    	assertTrue("This range should intersect with (19, 19)", exampleRange.intersects(19, 19));
    	assertTrue("This range should intersect with (-20, 19)", exampleRange.intersects(-20, 19));
    	assertTrue("This range should intersect with (-21, -19)", exampleRange.intersects(-21, -19));
    	assertFalse("This range should intersect with (20.5, 30)", exampleRange.intersects(20.5, 30));
    	
    	assertTrue("This range should intersect with (19, 20)", exampleRange.intersects(19, 20));
    	
    	assertFalse("This range should intersect with (20, 22)", exampleRange.intersects(20, 22));
    	
    	
    	
    	
    }
    
    @Test
    public void shouldIntersectTwoDoublesCase2() {
    	assertTrue("This range should intersect with (10, 20)", exampleRange.intersects(10, 20));
    }
    
    @Test
    public void shoundNotIntersectTwoDoublesCase2() {
    	assertFalse("This range should not intersect with (15, 10)", exampleRange.intersects(15, 10));
    }
    
    @Test
    public void shouldNotIntersectTwoDoubles() {
    	assertFalse("This range should not intersect with (30, 40)", exampleRange.intersects(30, 40));
    }
    
    @Test
    public void shouldNotIntersectRange() {
    	testRange = new Range(-40, -30);
    	assertFalse("This range should not intersect with (-40, -30)", exampleRange.intersects(testRange));
    }
    
    @Test
    public void shouldIntersectRange() {
    	testRange = new Range(10, 30);
    	assertTrue("This range should intersect with (10, 30)", exampleRange.intersects(testRange));
    }
    
    @Test 
    public void constrainEqualsToValue() {
    	assertEquals("If value is 10, then constrain should be 10", 
    			10, exampleRange.constrain(10), .000000001d);	
    }
    
    @Test
    public void constrainEqualsToLowerBound() {
    	assertEquals("If value is -30, then constrain should be -20", 
    			-20, exampleRange.constrain(-30), .000000001d);
    }
    
    @Test
    public void constrainEqualsToUpperBound() {
    	assertEquals("If value is 30, then constrain should be 20", 
    			20, exampleRange.constrain(30), .000000001d);
    }
    
    @Test
    public void testCombine1Null() {
    	assertEquals("Since range 1 is null, result range should be exampleRange", 
    			exampleRange, Range.combine(testRange, exampleRange));
    }
    
   @Test
    public void testCombine2Null() {
    	assertEquals("Since range 2 is null, result range should be exampleRange", 
    			exampleRange, Range.combine(exampleRange, testRange));
    }
   
    @Test
    public void testCombineNoNull() {
    	testRange = new Range(-30, 10);
    	resultRange = new Range(-30, 20);
    	assertEquals("Result range of exampleRange and (-30, 10) should be (-30, 20)",
    			resultRange, Range.combine(testRange, exampleRange));
    }
    
    
    
    @After
    public void tearDown() throws Exception {
    	testRange = null;
		assertNull(testRange);
		resultRange = null;
		assertNull(resultRange);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
