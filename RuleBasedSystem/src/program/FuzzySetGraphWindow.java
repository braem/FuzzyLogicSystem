package program;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import system.Pair;

/**
 * 
 * @author braem
 * @version 1.0
 */
public class FuzzySetGraphWindow extends ApplicationFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4949972124724025615L;

	public FuzzySetGraphWindow(String title, String chartTitle, ArrayList<Pair<Integer,Double>> points) {
		super(title);
		super.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		JFreeChart xyLineChart = ChartFactory.createXYLineChart(chartTitle, "", "",
				createSingleDataset(points, chartTitle), PlotOrientation.VERTICAL, true, true, false);
		setupChart(xyLineChart);
	}
	
	public FuzzySetGraphWindow(String title, String chartTitle, ArrayList<Pair<Integer,Double>> dPoints,
			ArrayList<Pair<Integer,Double>> lPoints, ArrayList<Pair<Integer,Double>> sPoints) {
		super(title);
		super.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		JFreeChart xyLineChart = ChartFactory.createXYLineChart(chartTitle, "", "",
				createMultipleDataset(dPoints, lPoints, sPoints, chartTitle), PlotOrientation.VERTICAL, true, true, false);
		setupChart(xyLineChart);
	}
	
	private void setupChart(JFreeChart xyLineChart) {
		ChartPanel chartPanel = new ChartPanel( xyLineChart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    final XYPlot plot = xyLineChart.getXYPlot( );
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	    renderer.setSeriesPaint( 0 , Color.RED ); 
	    renderer.setSeriesPaint( 1 , Color.GREEN );
	    renderer.setSeriesPaint( 2 , Color.BLUE );
	    renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	    renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	    renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
	    plot.setRenderer( renderer ); 
	    setContentPane( chartPanel ); 
	}
	
	private XYDataset createMultipleDataset(ArrayList<Pair<Integer,Double>> dPoints,
			ArrayList<Pair<Integer,Double>> lPoints, ArrayList<Pair<Integer,Double>> sPoints, String title) {
		final XYSeries difficulty = new XYSeries(title);
		for(Pair<Integer,Double> point : dPoints)
			difficulty.add(point.getFirst(), point.getSecond());
		final XYSeries learning = new XYSeries(title);
		for(Pair<Integer,Double> point : lPoints)
			learning.add(point.getFirst(), point.getSecond());
		final XYSeries success = new XYSeries(title);
		for(Pair<Integer,Double> point : sPoints)
			success.add(point.getFirst(), point.getSecond());
		
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(difficulty);
		dataset.addSeries(learning);
		dataset.addSeries(success);
		return dataset;
	}
	
	private XYDataset createSingleDataset(ArrayList<Pair<Integer,Double>> points, String title) {
		final XYSeries series = new XYSeries(title);
		for(Pair<Integer,Double> point : points)
			series.add(point.getFirst(), point.getSecond());
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		return dataset;
	}
	
	public void enable() {
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}
}
