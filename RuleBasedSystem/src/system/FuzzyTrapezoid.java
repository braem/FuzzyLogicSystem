package system;


/**
 * For this project, FuzzyValue represents a (possibly degenerate) trapezoidal fuzzy membership function.
 * 
 * @author Rhys
 * @version 1.0
 * */
public class FuzzyTrapezoid {
	
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
	 * @throws InvalidTrapezoidArgumentsException
	 */
	
	public FuzzyTrapezoid(double P1, double P2, double P3, double P4, double max, String n) throws InvalidTrapezoidArgumentsException
	{
		if(0 <= P1 && P1 <= P2 && P2 <= P3 && P3 <= P4)
		{
		setLeftZero(P1);
		setLeftHigh(P2);
		setRightHigh(P3);
		setRightZero(P4);
		setMaximum(max);
		setName(n);
		}
		else throw new InvalidTrapezoidArgumentsException();
		
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
	 * Sets the left zero.
	 * @param leftZero  A double value representing the horizontal placement of the left-most zero of the membership function.
	 */
	public void setLeftZero(double leftZero) {
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
	 * Sets the horizontal position of the left high point.
	 * @param leftHigh A double value representing the horizontal placement of the left-most high point of the membership function.
	 */
	public void setLeftHigh(double leftHigh) {
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
	 * Sets the horizontal position of the right high point.
	 * @param rightHigh A double value representing the horizontal placement of the right-most high point of the membership function.
	 */
	public void setRightHigh(double rightHigh) {
		this.rightHigh = rightHigh;
	}

	/**
	 * Returns the horizontal position of the right zero.
	 * @return rightZero Returns a double value representing the horizontal placement of the right-most zero of the membership function.
	 */
	public double getRightZero() {
		return rightZero;
	}

	/**
	 * Sets the horizontal position of the right zero.
	 * @param rightZero Returns a double value representing the horizontal placement of the right-most zero of the membership function.
	 */
	public void setRightZero(double rightZero) {
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
	public void setMaximum(double maximum) {
		this.maximum = maximum;
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

}
