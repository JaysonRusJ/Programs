package edu.nmsu.cs.circles;

public class Circle1 extends Circle {

	public Circle1(double x, double y, double radius) {
		super(x, y, radius);
	} // close parameter constructor

	public boolean intersects(Circle other) {
	
		// fix this
		if (Math.abs(center.x - other.center.x) <= radius + other.radius 
			&& Math.abs(center.y - other.center.y) <= radius + other.radius)
				return true;
			
		return false;
		
	} // close intersects

} // close class Circle1
