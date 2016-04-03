package system;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Rhys Beck
 *
 * @param <Input>
 */

public class DiscreteFuzzySet<Input>{

	ArrayList<Pair<Input, Double>> points;
	DiscreteLinguisticVariable<Input> var;
	
	Comparator<Pair<Input, Double>> comparator;
	String name;
	
	/**
	 * Constructs a new DiscreteFuzzySet. Sorts the points based on a Comparator provided by this set's DiscreteLinguisticVariable.
	 * @param pts	ArrayList<Pair<Input, Double>> which gives the points for this DiscreteFuzzySet
	 * @param name	The name of this DiscreteFuzzySet
	 * @param v		The DiscreteLinguisticVariable to which this set belongs.  Used to acquire comparator for sorting points.
	 */
	public DiscreteFuzzySet (ArrayList<Pair<Input, Double>> pts, String name, DiscreteLinguisticVariable<Input> v) 
	{
		setPoints(pts);
		this.name = name;
		this.var = v;
		
		comparator = new Comparator<Pair<Input, Double>>()
		{
			public int compare(Pair<Input, Double> first, Pair<Input, Double> second)
			{
				Comparator<Input> vc = v.getComparator();
				
				return vc.compare(first.getFirst(), second.getFirst());
			}
		};
		
		points.sort(comparator);  
	}
	
	/**
	 * Sets this fuzzy set's points to those provided
	 * @param points An ArrayList<Pair<Input, Double>> of points.
	 */
	public void setPoints(ArrayList<Pair<Input, Double>> points) {
		this.points = points;
	}

	/**
	 * Returns this fuzzy set's points
	 * @return an ArrayList<Pair<Input, Double>> containing this fuzzy set's points.
	 */
	public ArrayList<Pair<Input, Double>> getPoints() {
		return points;
	}
	
	/**
	 * Returns the name of this fuzzy set
	 * @return name A String giving the name of this fuzzy set.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this fuzzy set.
	 * @param name A String giving the new name of this fuzzy set.
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Adds the provided point to this fuzzy membership function, if it does not already exist, and then sorts the points.
	 * Otherwise, does nothing.
	 * @param Pair<Input, Double> giving the point to be added to the fuzzy membership function.
	 */
	private void addPoint( Pair<Input, Double> point) {
		if(!points.contains(point))
		{
			points.add(point);
		}
		
		points.sort(comparator);
	}


	/**
	 * Removes the indicated point from the fuzzy membership function.
	 * @param Pair<Input, Double> indicating the point to be removed.
	 * @return 
	 */
	private void removePoint(Pair<Input, Double> point) {
		points.remove(point);
	}


	/**
	 * Removes the old point, if it exists, and adds the new one, if it does not already exist.
	 * Sorts the points if any new points were added.
	 * @param oldP A Pair<Input, Double>  giving the point to be relocated.
	 * @param newP A Pair<Input, Double>  giving the new location of the point.
	 */
	public void movePoint(Pair<Input, Double>  oldP, Pair<Input, Double>  newP) {
		removePoint(oldP);
		addPoint(newP);
		
	}

	/**
	 * Returns the input's membership value in this fuzzy set.
	 * @param input an Input value whose membership is to be determined.
	 * @return	a double value representing the Input's membership in this fuzzy set.
	 * 			-1.0 indicates the value does not have a defined membership.
	 */
	public double getMembership(Input input) {

		for(Pair<Input, Double> pair : points)
		{
			if(pair.getFirst().equals(input)) return pair.getSecond();
		}
		
		return -1.0;
	}
	
	/**
	 * Overrides the Object toString method.  Returns the name of this FuzzyTrapezoid.
	 */
	public String toString()
	{
		return name;
	}
	

}
