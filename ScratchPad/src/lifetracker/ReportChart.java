package lifetracker;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import lifetracker.Report.TokenCountsByDate;

public class ReportChart extends JPanel {
	
	private Report report;
	
	static {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow",
                true));
    }
	
	public ReportChart(Report report) {
        
		this.report = report;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new LeftJustifiedPanelContainer("Tracker: " + report.getName()));
		if (report.getStatus() == ReportStatusEnum.OK){
			
			ChartPanel chartPanel = (ChartPanel) createChartPanel(report);
			chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
			this.add(chartPanel);
		} else { 
			JLabel noDataLabel = new JLabel("No data for tracker " + report.getName());
			this.add(noDataLabel);
		}
    }
	
	 private static JFreeChart createChart(Report report, XYDataset dataset) {
		 
	        JFreeChart chart = ChartFactory.createTimeSeriesChart(
	            report.getName() + " Events",  // title
	            "Date",             // x-axis label
	            "Number of " + report.getName(),   // y-axis label
	            dataset,            // data
	            true,               // create legend?
	            true,               // generate tooltips?
	            false               // generate URLs?
	        );

	        chart.setBackgroundPaint(Color.white);

	        XYPlot plot = (XYPlot) chart.getPlot();
	        plot.setBackgroundPaint(Color.lightGray);
	        plot.setDomainGridlinePaint(Color.white);
	        plot.setRangeGridlinePaint(Color.white);
	        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
	        plot.setDomainCrosshairVisible(true);
	        plot.setRangeCrosshairVisible(true);
	        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	        rangeAxis.setAutoRangeIncludesZero(true);
	        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	        XYItemRenderer r = plot.getRenderer();
	        if (r instanceof XYLineAndShapeRenderer) {
	            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
	            renderer.setBaseShapesVisible(true);
	            renderer.setBaseShapesFilled(true);
	            renderer.setDrawSeriesLineAsPath(true);
	        }

	        DateAxis axis = (DateAxis) plot.getDomainAxis();
	        axis.setDateFormatOverride(new SimpleDateFormat("MM-dd-yyyy"));

	        return chart;

	    }

	    /**
	     * Creates a dataset, consisting of two series of monthly data.
	     *
	     * @return The dataset.
	     */
	    private static XYDataset createCountDataset(Report report) {

	        TimeSeries ts = new TimeSeries(report.getName());
	        
	        LinkedHashMap<Date, Integer> data = report.getReportCountData(); 
	        
	        for (Map.Entry<Date, Integer> entry : data.entrySet()) {
	        	
	        	Date date = entry.getKey();
	        	Calendar cal = Calendar.getInstance();
	            cal.setTime(date);
	            Integer day = cal.get(Calendar.DAY_OF_MONTH);
	            Integer month = cal.get(Calendar.MONTH);
	            Integer year = cal.get(Calendar.YEAR);
	    
	        	ts.add(new Day(day, month, year), entry.getValue());
			}
	         	
	       	        		
	        TimeSeriesCollection dataset = new TimeSeriesCollection();
	        dataset.addSeries(ts);

	        return dataset;

	    }

	    private static XYDataset createTokenCountDataset(Report report) {

	        
	        TreeMap<String, TokenCountsByDate<Date,Integer>> data = report.getReportTokenData(); 
	        TimeSeriesCollection dataset = new TimeSeriesCollection();
	        
	        for (Map.Entry<String, TokenCountsByDate<Date,Integer>> tokenStringEntry : data.entrySet()) {
	        	// For each token string, get the counts by date, set on data series
	        	// to do: can I fill in zero for dates without data? 
	        	
	        	String token = tokenStringEntry.getKey();
	        	
	        	TimeSeries ts = new TimeSeries(token);
	        	TokenCountsByDate<Date,Integer> tokenCountsByDate = tokenStringEntry.getValue();
	        		for (Map.Entry<Date, Integer> dateEntry : tokenCountsByDate.entrySet() ) {
	        			Calendar cal = Calendar.getInstance();
	    	            cal.setTime(dateEntry.getKey());
	    	            Integer day = cal.get(Calendar.DAY_OF_MONTH);
	    	            Integer month = cal.get(Calendar.MONTH);
	    	            Integer year = cal.get(Calendar.YEAR);
	    	            ts.add(new Day(day, month, year), dateEntry.getValue());
	        		}
	        	
	        	
	     	    dataset.addSeries(ts);
	 
	  
			}

	        return dataset;

	    }
	    
	    
	    /**
	     * Blah Blah
	     *
	     * @return A panel.
	     */
	    public static JPanel createChartPanel(Report report) {
	    	JFreeChart chart;
	    	if (report.getTrackerType() == TrackerEnum.ACTIONTRACKER){
	    		chart = createChart(report, createTokenCountDataset(report));
	    	} else {
	    		chart = createChart(report, createCountDataset(report));
	    	}
	        ChartPanel panel = new ChartPanel(chart);
	        panel.setFillZoomRectangle(true);
	        panel.setMouseWheelEnabled(true);
	        return panel;
	    }

	
	
	

}
