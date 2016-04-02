package system;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class FuzzySetOperations {

	public static PiecewiseLinearFuzzySet AND(double firstElem, double secondElem, PiecewiseLinearFuzzySet first, PiecewiseLinearFuzzySet second)
	{
		FuzzyOutputSet result = new FuzzyOutputSet(new ArrayList<Point2D.Double>());
		
		double maximum = Math.min(first.getMembership(firstElem), second.getMembership(secondElem));
		
		
		for(Point2D.Double point : first.getPoints())
		{
			if(point.getY() <= maximum) result.addPoint(point);
			else result.addPoint(new Point2D.Double(point.getX(), maximum));
		}
		
		for(Point2D.Double point : second.getPoints())
		{
			result.addPoint(point);
		}
		
		return result;
	}
	
	public static PiecewiseLinearFuzzySet OR(PiecewiseLinearFuzzySet first, PiecewiseLinearFuzzySet second)
	{
		
	}
}
