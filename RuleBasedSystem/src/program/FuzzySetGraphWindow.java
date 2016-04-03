package program;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

public class FuzzySetGraphWindow extends ApplicationFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4949972124724025615L;

	public FuzzySetGraphWindow(String title, String chartTitle) {
		super(title);
		JFreeChart xyLineChart = ChartFactory.createXYLineChart(chartTitle, "", "", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel( xyLineChart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    final XYPlot plot = xyLineChart.getXYPlot( );
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	    renderer.setSeriesPaint( 0 , Color.RED ); 
	    renderer.setSeriesPaint( 1 , Color.GREEN );
	    renderer.setSeriesPaint( 2 , Color.YELLOW );
	    renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	    renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	    renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
	    plot.setRenderer( renderer ); 
	    setContentPane( chartPanel ); 
	}
	
	private XYDataset createDataset() {
		//TODO
		return null;
	}

}
