package system;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * For this project, FuzzyValue represents a (possibly degenerate) trapezoidal fuzzy membership function.
 * 
 * @author Rhys
 * @version 1.0
 * */
public class FuzzyTrapezoid implements Serializable, PiecewiseLinearFuzzySet{

	private static final long serialVersionUID = -1762880494226392800L;
	private double leftZero;
	private double leftHigh;
	private double rightHigh;
	private double rightZero;
	private double maximum;
	private String name;

	/**
	 * Constructs a new fuzzy value.
	 * @param P1 A double value representing the horizontal placement of the left-most zero of the membership function.
	 * @param P2 A double value representing the horizontal placement of the left-most high-point of the membership function.
	 * @param P3 A double value representing the horizontal placement of the right-most high-point of the membership function.
	 * @param P4 A double value representing the horizontal placement of the right-most zero of the membership function.
	 * @param P5 A double value representing the vertical placement of the plateau at the top of the trapezoid.
	 * @param n  A String giving the name of the fuzzy set.
	 * @throws FuzzyTrapezoidInvalidPointsException
	 * @throws FuzzyTrapezoidNegativeMaximumException
	 */
	
	public FuzzyTrapezoid(double P1, double P2, double P3, double P4, double max, String n) throws FuzzyTrapezoidInvalidPointsException, FuzzyTrapezoidNegativeMaximumException
	{
		if(verifyPoints(P1,P2,P3,P4))
		{
			setLeftZero(P1);
			setLeftHigh(P2);
			setRightHigh(P3);
			setRightZero(P4);
			setMaximum(max);
			setName(n);
		}
		else throw new FuzzyTrapezoidInvalidPointsException();
		
	}
	
	/**
	 * Verifies that the arguments are ordered correctly.
	 * @param P1 A double value representing the horizontal placement of the left-most zero of the membership function.
	 * @param P2 A double value representing the horizontal placement of the left-most high-point of the membership function.
	 * @param P3 A double value representing the horizontal placement of the right-most high-point of the membership function.
	 * @param P4 A double value representing the horizontal placement of the right-most zero of the membership function.
	 * @param max
	 * @return	<code>true</code> if 0 <= P1 && P1 <= P2 && P2 <= P3 && P3 <= P4
	 *          <code>false</code> otherwise
	 */
	private boolean verifyPoints(double P1, double P2, double P3, double P4)
	{
		return 0 <= P1 && P1 <= P2 && P2 <= P3 && P3 <= P4;
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
	 * Returns the left zero.
	 * @return leftZero Returns a double value representing the horizontal placement of the left-most zero of the membership function.
	 */
	public double getLeftZero() {
		return leftZero;
	}

	/**
	 * Sets the left zero to the specified value if it is consistent with a trapezoid.
	 * Otherwise, does nothing.
	 * @param leftZero  A double value representing the horizontal placement of the left-most zero of the membership function.
	 */
	public void setLeftZero(double leftZero) {
		if(verifyPoints(leftZero, this.leftHigh, this.rightHigh, this.rightZero))
		this.leftZero = leftZero;
	}

	/**
	 * Returns the horizontal position of the left high point.
	 * @return leftHigh Returns a double value representing the horizontal placement of the left-most  of the membership function.
	 */
	public double getLeftHigh() {
		return leftHigh;
	}

	/**
	 * Sets the horizontal position of the left high point to the specified value if it is consistent with a trapezoid.
	 * Otherwise, does nothing.
	 * @param leftHigh A double value representing the horizontal placement of the left-most high point of the membership function.
	 */
	public void setLeftHigh(double leftHigh) {
		if(verifyPoints(this.leftZero, leftHigh, this.rightHigh, this.rightZero))
		this.leftHigh = leftHigh;
	}

	/**
	 * Returns the horizontal position of the right high point.
	 * @return rightHigh Returns a double value representing the horizontal placement of the right-most high point of the membership function.
	 */
	public double getRightHigh() {
		return rightHigh;
	}

	/**
	 * Sets the horizontal position of the right high point to the specified value if it is consistent with a trapezoid.
	 * Otherwise, does nothing.
	 * @param rightHigh A double value representing the horizontal placement of the right-most high point of the membership function.
	 */
	public void setRightHigh(double rightHigh) {
		if(verifyPoints(this.leftZero, this.leftHigh, rightHigh, this.rightZero))
		this.rightHigh = rightHigh;
	}

	/**
	 * Returns the horizontal position of the right zero
	 * @return rightZero Returns a double value representing the horizontal placement of the right-most zero of the membership function.
	 */
	public double getRightZero() {
		return rightZero;
	}

	/**
	 * Sets the horizontal position of the right zero to the specified value if it is consistent with a trapezoid.
	 * Otherwise, does nothing.
	 * @param rightZero Returns a double value representing the horizontal placement of the right-most zero of the membership function.
	 */
	public void setRightZero(double rightZero) {
		if(verifyPoints(this.leftZero, this.leftHigh, this.rightHigh, rightZero))
		this.rightZero = rightZero;
	}

	/**
	 * Returns the vertical position of the maximum.
	 * @return maximum Returns a double value representing the vertical placement of the maximum of the membership function.
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * Sets the vertical position of the maximum.
	 * @param maximum  A double value representing the vertical placement of the maximum of the membership function.
	 */
	public void setMaximum(double maximum) throws FuzzyTrapezoidNegativeMaximumException 
	{
		if(maximum >= 0) this.maximum = maximum;
		else throw new FuzzyTrapezoidNegativeMaximumException() ;
	}
	
	/**
	 * Returns the input's membership value in this fuzzy set.
	 * @param input a double input value
	 * @return	a double value representing the input's membership in this fuzzy set.
	 */
	public double getMembership(double input)
	{
		double membership = 0.0;
		
		if(leftZero <= input && input <= leftHigh)
		{//input falls on or between the first two points of the trapezoid.
			if(leftZero != leftHigh)
			{//non-vertical rising line-segment
				double slope = maximum / (leftHigh - leftZero);
				membership = slope * (input - leftZero);
			}
			else//vertical rising line segment
			{
				membership = maximum;
			}
		}
		else if(leftHigh <= input && input <= rightHigh)
		{//input falls on or between the peak values.
			membership = maximum;
		}
		else if(rightHigh <= input && input <= rightZero)
		{//input falls on or between the last two points of the trapezoid.
			
			if(rightHigh != rightZero)
			{//Non-vertical line-segment			
				double slope = maximum / (leftHigh - leftZero);
				membership = slope * (input - rightZero);
			}
			else //vertical line segment
			{
				membership = maximum;
			}
		}
	
		return membership;
	}
	
	/**
	 * Overrides the Object toString method.  Returns the name of this FuzzyTrapezoid.
	 */
	public String toString()
	{
		return name;
	}
	
	/**
	 * Tests if this FuzzyTrapezoid is the same as another.
	 * @param ft A FuzzyTrapezoid for equality testing.
	 * @return	<code>true</code> if equal
	 *          <code>false</code> if not equal.
	 */
	public boolean equals(FuzzyTrapezoid ft)
	{
		return 	ft.getName().equals(this.getName()) &&
				ft.getLeftZero() == this.getLeftZero() &&
				ft.getLeftHigh() == this.getLeftHigh() &&
				ft.getRightHigh() == this.getRightHigh() &&
				ft.getRightZero() == this.getRightZero() &&
				ft.getMaximum() == this.getMaximum();
	}

	/**
	 * implemented from the PiecewiseLinearFuzzySet interface
	 * @return an ArrayList<Point2D.Double> giving the end points of the line segments that make up
	 * this fuzzy set's membership function.
	 */
	@Override
	public ArrayList<Point2D.Double> getPoints() {
		
		ArrayList<Point2D.Double> points = new ArrayList<>();
		
		points.add(new Point2D.Double(leftZero, 0.0));
		points.add(new Point2D.Double(leftHigh, maximum));
		points.add(new Point2D.Double(rightHigh, maximum));
		points.add(new Point2D.Double(rightZero, 0.0));
		
		return points;
	}
	
	/**
	 * Required by the PiecewiseLinearFuzzySet interface.  Not used.
	 */
	@Override
	public void addPoint(Point2D.Double point){}

	/**
	 * Required by the PiecewiseLinearFuzzySet interface.  Not used.
	 */
	@Override
	public void removePoint(Point2D.Double point){}		

	/**
	 * Required by the PiecewiseLinearFuzzySet interface. 
	 * Moves the indicated point to a new location, if the point exists.
	 * Otherwise does nothing.
	 * @param oldP A Point2D.Double giving the point to be relocated.
	 * @param newP A Point2D.Double giving the new location of the point.
	 */
	@Override
	public void movePoint(Point2D.Double oldP, Point2D.Double newP) {
		
		double oldPoint = 0;
		double oldX = oldP.getX();
		double oldY = oldP.getY();
		
		if(oldX == leftZero && oldY == 0) 
		{
			leftZero = newP.getX();
		}
		else if(oldX == leftHigh && oldY == maximum)
		{
			leftHigh = newP.getX();
			maximum = newP.getY();
		}
		else if(oldX == rightHigh && oldY == maximum)
		{
			rightHigh = newP.getX();
			maximum = newP.getY();
		}
		if(oldX == rightZero && oldY == 0) 
		{
			rightZero = newP.getX();
		}
		
	}
	
	

}
