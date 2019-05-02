package problem453;

public class Segment
{
	private Point leftPoint, rightPoint;
	
	// default constructor made private so it cannot be used.
	private Segment()
	{
			
	}
	
	public Segment(Point p1, Point p2)
	{
		if(p1.getX() <= p2.getX())
		{
			this.leftPoint = p1;
			this.rightPoint = p2;
		}
		else
		{
			this.leftPoint = p2;
			this.rightPoint = p1;
		}
	}
	
	public Point getLeftPoint()
	{
		return leftPoint;
	}
	
	public Point getRightPoint()
	{
		return rightPoint;
	}
	
	public boolean containsPoint(Point testPoint)
	{
		return leftPoint == testPoint || rightPoint == testPoint;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Segment)) return false;
	    Segment otherSegment = (Segment) other;
	    
		return this.leftPoint  == otherSegment.getLeftPoint() && 
				this.rightPoint == otherSegment.getRightPoint();
	}
	
	@Override
	public String toString()
	{
		return leftPoint.toString() + " -> " + rightPoint.toString();
	}
	

	public static void main(String[] args)
	{
		// Same points
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,0);
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p2, p1);
		
		System.out.println("S1: " + s1);
		System.out.println("S2: " + s2);
		
		assert(s1 == s2);
		assert(s1.getLeftPoint() == p1);
		assert(s1.getRightPoint() == p2);
		assert(s2.getLeftPoint() == p1);
		assert(s2.getRightPoint() == p2);
		
		// Vary Y
		Point p3 = new Point(3,12);
		Point p4 = new Point(3,7);
		Segment s3 = new Segment(p3, p4);
		Segment s4 = new Segment(p4, p3);
		
		System.out.println("S3: " + s3);
		System.out.println("S4: " + s4);
		
		assert(s3 == s4);
		assert(s3.getLeftPoint() == p3);
		assert(s3.getRightPoint() == p4);
		assert(s4.getLeftPoint() == p3);
		assert(s4.getRightPoint() == p4);
		
		// Vary X
		Point p5 = new Point(11,6);
		Point p6 = new Point(4,6);
		Segment s5 = new Segment(p5, p6);
		Segment s6 = new Segment(p6, p5);
		
		System.out.println("S5: " + s5);
		System.out.println("S6: " + s6);
		
		assert(s5 == s6);
		assert(s5.getLeftPoint() == p6);
		assert(s5.getRightPoint() == p5);
		assert(s6.getLeftPoint() == p6);
		assert(s6.getRightPoint() == p5);
		
		// Test containsPoint functionality
		assert(s1.containsPoint(p1));
		assert(s1.containsPoint(p2));
		
		assert(!s1.containsPoint(p3));
		assert(!s1.containsPoint(p4));
		
		System.out.println("Segment unit tests completed");
	}
}

