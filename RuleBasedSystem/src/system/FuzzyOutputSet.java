package system;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Comparator;

public class FuzzyOutputSet implements PiecewiseLinearFuzzySet{

	ArrayList<Point2D.Double> points;
	Comparator<Point2D.Double> XComparator = new Comparator<Point2D.Double>(){
		public int compare(Point2D.Double first, Point2D.Double second)
		{
			int retVal = 0;
			
			if(first.getX() < second.getX()) retVal = -1;
			else if(first.getX()> second.getX()) retVal = 1;
			
			return retVal;
		}
	};
	
	
	
	public FuzzyOutputSet(ArrayList<Point2D.Double> pts)
	{
		points = pts;
	}
	
	/**
	 * Implemented from the PiecewiseLinearFuzzySet interface.
	 * Returns an ArrayList<Point2D.double> giving the end points of the line segments that make up this
	 * fuzzy membership function.  The points are sorted by increasing order of X coordinate.
	 */
	@Override
	public ArrayList<Double> getPoints() {
		points.sort(XComparator);
		return points;
	}

	/**
	 * Implemented from the PiecewiseLinearFuzzySet interface.
	 * Adds the provided point to this fuzzy membership function, if it does not already exist, and then sorts the points.
	 * Otherwise, does nothing.
	 * @param Point2D.Double giving the point to be added to the fuzzy membership function.
	 */
	@Override
	public void addPoint(Double point) {
		if(!points.contains(point))
		{
			points.add(point);
			points.sort(XComparator);
		}
	}

	/**
	 * Removes the indicated point from the fuzzy membership function.
	 * @param Point2D.Double indicating the point to be removed.
	 */
	@Override
	public void removePoint(Point2D.Double point) {
		points.remove(point);
		
	}
	
	/**
	 * Removes the old point, if it exists, and adds the new one, if it does not already exist.
	 * Sorts the points if any new points were added.
	 * @param oldP A Point2D.Double giving the point to be relocated.
	 * @param newP A Point2D.Double giving the new location of the point.
	 */
	@Override
	public void movePoint(Point2D.Double oldP, Point2D.Double newP) {
		removePoint(oldP);
		addPoint(newP);
		
	}
	

}
