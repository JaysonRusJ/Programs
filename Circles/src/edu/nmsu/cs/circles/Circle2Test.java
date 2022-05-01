package edu.nmsu.cs.circles;

/***
 * Example JUnit testing class for Circle2 (and Circle)
 *
 * - must have your classpath set to include the JUnit jarfiles - to run the test do: java
 * org.junit.runner.JUnitCore Circle2Test - note that the commented out main is another way to run
 * tests - note that normally you would not have print statements in a JUnit testing class; they are
 * here just so you see what is happening. You should not have them in your test cases.
 ***/

import org.junit.*;

public class Circle2Test
{
	// Data you need for each test case
	private Circle2 circle2;

	//
	// Stuff you want to do before each test case
	//
	@Before
	public void setup()
	{
		System.out.println("\nTest starting...");
		circle2 = new Circle2(1, 2, 3);
	}

	//
	// Stuff you want to do after each test case
	//
	@After
	public void teardown()
	{
		System.out.println("\nTest finished.");
	}
	
	/*
	 * Test two circles that do not touch each other
	 */
	 @Test
	public void intersectNoIntersection() {
	
		System.out.println("Running Test: intersectNoIntersection");
		
		// next to each other with same x
		System.out.println("intersectNoIntersection Test: far apart");
		Circle2 baseCircle = new Circle2(0,50,10);
		Circle2 nextCircle = new Circle2(0,0,5);
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));
		
		// one above almost touching with same x
		System.out.println("intersectNoIntersection Test: almost touching on vertical");
		baseCircle = new Circle2(1,10,2.99);
		nextCircle = new Circle2(1,5,2);
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));
		
		// cirle above to the right
		System.out.println("intersectNoIntersection Test: above to right very close");
		baseCircle = new Circle2(16,121,4);
		nextCircle = new Circle2(25.5,128.55,5);
		Assert.assertFalse(baseCircle.intersects(nextCircle));
		Assert.assertFalse(nextCircle.intersects(baseCircle));
	
	} // close intersectNoIntersection
	
	/*
	 * Test two circles are perfectly on top of each other
	 */
	@Test
	public void intersectCompleteOverlap() {
		
		System.out.println("Running Test: intersectCompleteOverlap");
		
		System.out.println("intersectCompleteOverlap Test: at origin");
		Circle2 baseCircle = new Circle2(0,0,5);
		Circle2 nextCircle = new Circle2(0,0,5);
		Assert.assertTrue(baseCircle.intersects(nextCircle));
		Assert.assertTrue(nextCircle.intersects(baseCircle));
		
	} // close intersectCompleteOverlap
	
	/*
	 * Test two circles for 1 intersecting point
	 */
	@Test
	public void intersectAtOnePoint() {
		
		System.out.println("Running Test: intersectAtOnePoint");
		
		System.out.println("intersectAtOnePoint Test: on x axis");
		Circle2 baseCircle = new Circle2(0,0,3);
		Circle2 nextCircle = new Circle2(7,0,4);
		Assert.assertTrue(baseCircle.intersects(nextCircle));
		Assert.assertTrue(nextCircle.intersects(baseCircle));
		
	} // close intersectAtOnePoint
	
	/*
	 * Test circle factor 
	 */
	@Test
	public void simpleFactor() {
		
		System.out.println("Running Test: simpleFactor");
		
		Circle2 c = new Circle2(0,0,3);
		c.radius = c.scale(3.0);
		Assert.assertTrue(c.radius == 9.0);
		
	} // close simpleFactor


	//
	// Test a simple positive move
	//
	@Test
	public void simpleMove()
	{
		Point p;
		System.out.println("Running test simpleMove.");
		p = circle2.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
	}

	//
	// Test a simple negative move
	//
	@Test
	public void simpleMoveNeg()
	{
		Point p;
		System.out.println("Running test simpleMoveNeg.");
		p = circle2.moveBy(-1, -1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
	}

	/***
	 * NOT USED public static void main(String args[]) { try { org.junit.runner.JUnitCore.runClasses(
	 * java.lang.Class.forName("Circle2Test")); } catch (Exception e) { System.out.println("Exception:
	 * " + e); } }
	 ***/

}
