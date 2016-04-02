package system;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * This interface specified methods required to interact with piecewise linear fuzzy set membership functions.
 * @author Rhys Beck
 *
 */
public interface PiecewiseLinearFuzzySet {

	/**
	 * Returns the end points of the line segments making up this fuzzy set's membership function.
	 * @return an ArrayList<Point2D.Double> containing the end points of the line segments making up this fuzzy set's membership function.
	 */
	public ArrayList<Point2D.Double> getPoints();
	
	/**
	 * Adds the indicated end point to the fuzzy membership function.
	 * @param point A Point2D.Double to be added to the fuzzy membership function.
	 */
	public void addPoint(Point2D.Double point);
	
	/**
	 * Removes the indicated point from the fuzzy membership function.
	 * @param point A Point2D.Double to be removed from the fuzzy membership function.
	 */
	public void removePoint(Point2D.Double point);
	
	/**
	 * Moves the indicated point to a new location
	 * @param oldP A Point2D.Double indicating the point to be moved.
	 * @param newP A Point2D.Double indicating where the old point should be moved to.
	 */
	public void movePoint(Point2D.Double oldP, Point2D.Double newP);
	
	/**
	 * Returns the membership value associated with input value provided.
	 * @param input A double value whose membership is to be determined.
	 * @return A double value representing the membership of the input in this fuzzy set.
	 */
	public double getMembership(double input);

}

