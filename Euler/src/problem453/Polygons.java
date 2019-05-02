package problem453;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Polygons
{
	int numXPoints, numYPoints;
	private int pointSpace;
	private long numberCompletePolygons = 0;
	
	public Polygons(int x, int y)
	{
		numXPoints = x + 1;
		numYPoints = y + 1;
		pointSpace = numXPoints * numYPoints;
		generatePolygons();
	}
	
	public long getNumberOfCompletePolygons()
	{
		return numberCompletePolygons;
	}
	
	private void generatePolygons()
	{
		List<Point> currentPoints = new ArrayList<>();
		
		// generate p1
		for(int p1 = 0; p1 < pointSpace; p1++)
		{
			// generate p2
			for(int p2 = p1 + 1; p2 < pointSpace; p2++)
			{	
				// generate p3
				for(int p3 = p2 + 1; p3 < pointSpace; p3++)
				{
					// generate p4
					for(int p4 = p3 + 1; p4 < pointSpace; p4++)
					{
						// all points are unique at this point
						// convert pointspace points into coordinate points
						currentPoints.clear();
						currentPoints.add(pointSpaceToPoint(p1));
						currentPoints.add(pointSpaceToPoint(p2));
						currentPoints.add(pointSpaceToPoint(p3));
						currentPoints.add(pointSpaceToPoint(p4));
						
						// this set of points is unique and new
						// add it to the collection of generated point sets
						//generatedPolygons.add(new ArrayList<>(currentPoints));
						
						// create the three polygon permutations with these points
						Polygon polygon1 = new Polygon(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2), currentPoints.get(3));
						Polygon polygon2 = new Polygon(currentPoints.get(0), currentPoints.get(1), currentPoints.get(3), currentPoints.get(2));
						Polygon polygon3 = new Polygon(currentPoints.get(0), currentPoints.get(3), currentPoints.get(1), currentPoints.get(2));
						
						// check the polygons for straight angles and self intersection
						if(polygon1.isValid())
						{
							numberCompletePolygons++;
						}
						if(polygon2.isValid())
						{
							numberCompletePolygons++;
						}
						if(polygon3.isValid())
						{
							numberCompletePolygons++;
						}
					}
				}
			}
		}
	}
	
	private Point pointSpaceToPoint(int value)
	{
		return new Point(value%numXPoints, value/numXPoints);
	}
	
	public static void main(String[] args)
	{
		
		Scanner inputReader = new Scanner(System.in);
		int x = inputReader.nextInt();
		int y = inputReader.nextInt();
		inputReader.close();
		
		java.util.Date startDate = new Date();
		System.out.println("Start Time: " + startDate);
		
		Polygons polygonTester = new Polygons(x,y);
		long value = polygonTester.getNumberOfCompletePolygons();
		System.out.println("X: " + x + "	Y: " + y + "	S: " + value);
		
		java.util.Date endDate = new Date();
		System.out.println("End Time: " + endDate);
	}
}


