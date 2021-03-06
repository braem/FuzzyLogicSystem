package system;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Rhys Beck
 * @version 2.0
 *
 * @param <Input> The type of the x axis for this discrete fuzzy sets membership function.
 */

public class DiscreteFuzzySet<Input> implements Serializable{

	private static final long serialVersionUID = -5750115777879754506L;
	ArrayList<Pair<Input, Double>> points;
	DiscreteLinguisticVariable<Input> var;
	
	SerializableComparator<Pair<Input, Double>> comparator;
	String name;
	
	/**
	 * Constructs a new DiscreteFuzzySet. Sorts the points based on a Comparator provided by this set's DiscreteLinguisticVariable.
	 * @param pts	ArrayList&#60;Pair&#60;Input, Double&#62;&#62; which gives the points for this DiscreteFuzzySet
	 * @param name	The name of this DiscreteFuzzySet
	 * @param v		The DiscreteLinguisticVariable to which this set belongs.  Used to acquire comparator for sorting points.
	 */
	public DiscreteFuzzySet (ArrayList<Pair<Input, Double>> pts, String name, DiscreteLinguisticVariable<Input> v) 
	{
		setPoints(pts);
		this.name = name;
		this.var = v;
		
		comparator = new SerializableComparator<Pair<Input, Double>>()
		{
			private static final long serialVersionUID = 4712624533822769884L;

			public int compare(Pair<Input, Double> first, Pair<Input, Double> second)
			{
				Comparator<Input> vc = v.getComparator();
				
				return vc.compare(first.getFirst(), second.getFirst());
			}
		};
		
		points.sort(comparator);  
	}
	
	/**
	 * Copy constructor.
	 * @param toCopy The DiscreteFuzzySet&#60;Input&#62; to be copied.
	 */
	public DiscreteFuzzySet(DiscreteFuzzySet<Input> toCopy)
	{
		setPoints(toCopy.getPoints());
		this.name = toCopy.getName();
		this.var = toCopy.getLinguisticVariable();
	}
	
	/**
	 * Sets this fuzzy set's points to those provided
	 * @param points An ArrayList&#60;Pair&#60;Input, Double&#62;&#62; of points.
	 */
	public void setPoints(ArrayList<Pair<Input, Double>> points) {
		this.points = points;
	}

	/**
	 * Returns this fuzzy set's points
	 * @return an ArrayList&#60;Pair&#60;Input, Double&#62;&#62; containing this fuzzy set's points.
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
	 * Returns the DiscreteLinguisticVariable whose comparator is used for sorting this DiscreteFuzzySet.W
	 * @return DiscreteLinguisticVariable whose comparator is used for sorting this DiscreteFuzzySet.
	 */
	public DiscreteLinguisticVariable<Input> getLinguisticVariable()
	{
		return var;
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
	 * @param oldP A Pair&#60;Input, Double&#62;  giving the point to be relocated.
	 * @param newP A Pair&#60;Input, Double&#62;  giving the new location of the point.
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
	 * Truncates the fuzzy membership function at the maximum value provided.
	 * @param maximum a double value giving the new maximum membership of this DiscreteFuzzySet.
	 */
	public void truncate(double maximum)
	{
		for(Pair<Input, Double> pair : points)
		{
			if(pair.getSecond() > maximum) pair.setSecond(maximum);
		}
	}
	
	/**
	 * Returns a double representing the average Input value where the center of area of this fuzzy set falls.
	 * @return double double representing the average Input value where the center of area of this fuzzy set falls.
	 */
	public double numericDefuzzify()
	{

		return centerOfArea();

	}
	
	/**
	 * Returns the Input value where the center of area of this fuzzy set falls.
	 * @return Input value where the center of area of this fuzzy set falls.
	 */
	public Input typedDefuzzify()
	{	
		//Here, CoA is used to select an x-axis value to return.
		
		double weightedSum = centerOfArea();
		//Truncate, effectively applying the integer floor function.
		//This gives the index of the Input that should be returned.
		int sumInt = (int) weightedSum;
		
		return points.get(sumInt).getFirst();
		
	}
	
	/**
	 * Returns a double representing the average Input value where the center of area of this fuzzy set falls.
	 * @return double double representing the average Input value where the center of area of this fuzzy set falls.
	 */
	private double centerOfArea()
	{
		//As this is a discrete function, we can treat it as a function
		//comprised of rectangles of width 1.  The Center of Area
		//of this function will be the average of the centers of area
		//of each of the component rectangles, weighted by their heights.
		//The value returned is, thus, the true center of area
		//if the input values are mapped to integer-spaced real numbers
		//between 0 and one less than the number of points in the fuzzy set.
		
		double upperSum = 0;
		double lowerSum = 0;
		
		for(int i = 0 ; i < points.size(); i++ )
		{
			upperSum += (i) * points.get(i).getSecond();
			lowerSum += points.get(i).getSecond();
		}
		
		return upperSum / lowerSum;
	}

	/**
	 * Returns the DiscreteFuzzySet resulting from performing the fuzzy AND (minimum) operation
	 * on this set and the one provided.
	 * @param ander a DiscreteFuzzySet to AND with this one.
	 * @return the DiscreteFuzzySet resulting from performing the fuzzy AND (minimum) operation
	 * on this set and the one provided.
	 */
	public DiscreteFuzzySet<Input> AND(DiscreteFuzzySet<Input> ander)
	{
		ArrayList<Pair<Input, Double>> newValues = new ArrayList<>();
		
		if(ander.getPoints().size() == points.size())
		{
			for(int i = 0; i < this.points.size() ; i++)
			{
				newValues.add(new Pair<Input, Double>(points.get(i).getFirst(), Math.min(points.get(i).getSecond(), ander.getPoints().get(i).getSecond())));
			}
			
			return new DiscreteFuzzySet<Input>(newValues, name + " AND " + ander.getName(), this.getLinguisticVariable());
		}
		else return null;
	}
	
	/**
	 * Returns the DiscreteFuzzySet resulting from performing the fuzzy OR (maximum) operation
	 * on this set and the one provided.
	 * @param orer a DiscreteFuzzySet to OR with this one.
	 * @return the DiscreteFuzzySet resulting from performing the fuzzy OR (maximum) operation
	 * on this set and the one provided.
	 */
	public DiscreteFuzzySet<Input> OR(DiscreteFuzzySet<Input> orer)
	{
		ArrayList<Pair<Input, Double>> newValues = new ArrayList<>();
		
		if(orer.getPoints().size() == points.size())
		{
			for(int i = 0; i < this.points.size() ; i++)
			{
				newValues.add(new Pair<Input, Double>(points.get(i).getFirst(), Math.max(points.get(i).getSecond(), orer.getPoints().get(i).getSecond())));
			}
			
			return new DiscreteFuzzySet<Input>(newValues, name + " OR " + orer.getName(), this.getLinguisticVariable());
		}
		else return null;
	}
	
	/**
	 * Overrides the Object toString method.  Returns the name of this DiscreteFuzzySet.
	 */
	public String toString()
	{
		return name;
	}
	

}
