package problem453;

public class Point
{
	private int x, y;
	
	// default constructor made private so it cannot be used.
	private Point()
	{
		
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Point)) return false;
	    Point otherPoint = (Point) other;
		return this.x  == otherPoint.getX() && this.y == otherPoint.getY();
	}
	
	@Override
	public String toString()
	{
		return "[" + x + "," + y + "]";
	}
	
	public static void main(String[] args)
	{
		// Test equality with zero values
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,0);
		
		// Test equality with non-zero values
		Point p3 = new Point(5,7);
		Point p4 = new Point(5,7);
		
		Point p5 = new Point(1,4);
		
		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		System.out.println("P3: " + p3);
		System.out.println("P4: " + p4);
		System.out.println("P5: " + p5);
		
		assert(p1 == p2);
		assert(p3 == p4);
		assert(p1 != p3);
		assert(p1 != p5);
		assert(p3 != p5);
		
		System.out.println("Point unit tests completed");
	}
}
