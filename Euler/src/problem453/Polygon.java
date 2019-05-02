package problem453;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Polygon
{

	private Point p1, p2, p3, p4;
	//private orientation orientation1, orientation2, orientation3, orientation4;
	
	// This polygon class assumes the polygon segments are connected in order
	// The following line segments are expected:
	// p1 - p2
	// p2 - p3
	// p3 - p4
	// p4 - p1
	public Polygon(Point p1, Point p2, Point p3, Point p4)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	/*
	// Attempt 1
	public boolean isValid()
	{
		if(hasZeroAngle() || hasIntersections())
		{
			return false;
		}
		
		return true;
	}
	
	private boolean hasZeroAngle()
	{
		return getOrientation(p1, p2, p3) == orientation.COLLINEAR || 
				getOrientation(p2, p3, p4) == orientation.COLLINEAR ||
				getOrientation(p3, p4, p1) == orientation.COLLINEAR || 
				getOrientation(p4, p1, p2) == orientation.COLLINEAR;
				
	}
	
	private boolean hasIntersections()
	{
		if(intersects(p1, p2, p3, p4) || intersects(p2, p3, p4, p1)) return true;
		return false;
	}
	
	private boolean intersects(Point p1, Point p2, Point p3, Point p4)
	{
		if(getOrientation(p1, p2, p3) != getOrientation(p1, p2, p4) && getOrientation(p3, p4, p1) != getOrientation(p3, p4, p2))
		{
			return true;
		}
		return false;
	}
	*/
	
	
	/*
	// Attempt 2
	public boolean isValid()
	{
		orientation1 = getOrientation(p1, p2, p3);
		if(orientation1 == orientation.COLLINEAR)
		{
			return false;
		}
		else
		{
			orientation2 = getOrientation(p2, p3, p4);
			if(orientation2 == orientation.COLLINEAR)
			{
				return false;
			}
			else
			{
				orientation3 = getOrientation(p3, p4, p1);
				if(orientation3 == orientation.COLLINEAR)
				{
					return false;
				}
				else
				{
					orientation4 = getOrientation(p4, p1, p2);
					if(orientation4 == orientation.COLLINEAR)
					{
						return false;
					}
					else
					{
						// No three points were collinear, i.e. no zero angles in this polygon.
						// Check for intersections
						orientation orientation5 = getOrientation(p1, p2, p4);
						orientation orientation6 = getOrientation(p3, p4, p2);
						if(orientation1 != orientation5 && orientation3 != orientation6)
						{
							return false;
						}
						else
						{							
							orientation orientation7 = getOrientation(p2, p3, p1);
							orientation orientation8 = getOrientation(p4, p1, p3);
							if(orientation2 != orientation7 && orientation4 != orientation8)
							{
								return false;
							}
							else
							{
								return true;
							}
						}
					}
				}
			}
		}
	}
	*/
	
	public boolean isValid()
	{
		if(hasZeroAngle() || hasIntersections())
		{
			return false;
		}
		
		return true;
	}
	
	private boolean hasZeroAngle()
	{
		return getOrientation(p1, p2, p3) == orientation.COLLINEAR || 
				getOrientation(p2, p3, p4) == orientation.COLLINEAR ||
				getOrientation(p3, p4, p1) == orientation.COLLINEAR || 
				getOrientation(p4, p1, p2) == orientation.COLLINEAR;
				
	}
	
	private boolean hasIntersections()
	{
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p2, p3);
		Segment s3 = new Segment(p3, p4);
		Segment s4 = new Segment(p4, p1);
		
		// TODO Test intersection between segment 1 and segment 3
		
		// TODO Test intersection between segment 2 and segment 4
		
		return false;
	}
	
	private enum orientation
	{
		COUNTERCLOCKWISE,
		COLLINEAR,
		CLOCKWISE
	}
	
	private orientation getOrientation(Point p1, Point p2, Point p3)
	{
		int crossProduct = ((p2.getY() - p1.getY()) * (p3.getX() - p2.getX())) - ((p2.getX() - p1.getX()) * (p3.getY() - p2.getY()));
		if(crossProduct < 0)
		{
			return orientation.COUNTERCLOCKWISE;
		}
		else if(crossProduct > 0)
		{
			return orientation.CLOCKWISE;
		}
		else
			return orientation.COLLINEAR;
	}
	
	@Override
	public String toString()
	{
		return p1.toString() + " " + p2.toString() + " " + p3.toString() + " " + p4.toString();
	}
}
