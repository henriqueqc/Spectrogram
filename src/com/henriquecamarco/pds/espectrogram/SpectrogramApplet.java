package com.henriquecamarco.pds.espectrogram;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JApplet;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;

import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.ui.RectangleInsets;

public class SpectrogramApplet extends JApplet {
	private static final long serialVersionUID = 11234123L;
	private double series[][];// = new double[1000][1000];

	public void init() {
		series = new double[3][10];

		// Set the x coordinate of the points
		series[0][0] = 0;
		series[0][1] = 0;
		series[0][2] = 0;
		series[0][3] = 0;
		series[0][4] = 0;

		// Set the y coordinate of the 5 red points.
		series[1][0] = 0;
		series[1][1] = 1;
		series[1][2] = 2;
		series[1][3] = 3;
		series[1][4] = 4;

		// Set the z coordinate of the 5 red points.
		series[2][0] = 2;
		series[2][1] = 2;
		series[2][2] = 2;
		series[2][3] = 3;
		series[2][4] = 4;
		
		// Set the x coordinate of the points
		series[0][5] = 1;
		series[0][6] = 1;
		series[0][7] = 1;
		series[0][8] = 1;
		series[0][9] = 1;

		// Set the y coordinate of the 5 red points.
		series[1][5] = 0;
		series[1][6] = 1;
		series[1][7] = 2;
		series[1][8] = 3;
		series[1][9] = 4;

		// Set the z coordinate of the 5 red points.
		series[2][5] = 2;
		series[2][6] = 3;
		series[2][7] = 3;
		series[2][8] = 4;
		series[2][9] = 4;

		// Get the graph (generateGraph will create the JFreeChart graph and add
		// the red and blue point on it).
		JFreeChart jFreeChart = generateGraph();

		// Put the jFreeChart in a chartPanel
		ChartPanel chartPanel = new ChartPanel(jFreeChart);
		chartPanel.setPreferredSize(new Dimension(900, 600));

		chartPanel.setPopupMenu(null);
		// add the chartPanel to the container (getContentPane is inherited from
		// JApplet which AppletGraph extends).
		Container content = getContentPane();
		GridLayout layout = new GridLayout();
	
		content.setLayout(layout);
		
		content.add(chartPanel);
		content.add(new ChartPanel(generateColorBar(0)));
		content.validate();

	}

	public JFreeChart generateGraph() {

		DefaultXYZDataset dataset = new DefaultXYZDataset();

		dataset.addSeries("", series);

		ValueAxis abscisse = new NumberAxis("Time");
		ValueAxis ordinate = new NumberAxis("Frequency");

		abscisse.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		ordinate.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		XYBlockRenderer renderer = new XYBlockRenderer();

		renderer.setPaintScale(new GrayPaintScale(0, 6));

		XYPlot xyPlot = new XYPlot(dataset, abscisse, ordinate, renderer);

		xyPlot.setAxisOffset(new RectangleInsets());

		JFreeChart jFreeChart = new JFreeChart(xyPlot);

		return jFreeChart;
	}

	public JFreeChart generateColorBar(double maxValue) {
		double barSeries[][] = new double[3][7];

		// Set the x coordinate of the points
		barSeries[0][0] = 0;
		barSeries[0][1] = 0;
		barSeries[0][2] = 0;
		barSeries[0][3] = 0;
		barSeries[0][4] = 0;
		barSeries[0][5] = 0;
		barSeries[0][6] = 0;

		// Set the y coordinate of the points
		barSeries[1][0] = 0;
		barSeries[1][1] = 1;
		barSeries[1][2] = 2;
		barSeries[1][3] = 3;
		barSeries[1][4] = 4;
		barSeries[1][5] = 5;
		barSeries[1][6] = 6;

		// Set the y coordinate of the points
		barSeries[2][0] = 0;
		barSeries[2][1] = 1;
		barSeries[2][2] = 2;
		barSeries[2][3] = 3;
		barSeries[2][4] = 4;
		barSeries[2][5] = 5;
		barSeries[2][6] = 6;

		DefaultXYZDataset dataset = new DefaultXYZDataset();

		dataset.addSeries("", barSeries);

		ValueAxis abscisse = new NumberAxis(null);
		ValueAxis ordinate = new NumberAxis("dB");

		abscisse.setVisible(false);

		ordinate.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		XYBlockRenderer renderer = new XYBlockRenderer();

		renderer.setPaintScale(new GrayPaintScale(0, 6));

		XYPlot xyPlot = new XYPlot(dataset, abscisse, ordinate, renderer);

		xyPlot.setAxisOffset(new RectangleInsets());

		JFreeChart jFreeChart = new JFreeChart(xyPlot);

		return jFreeChart;
	}
}