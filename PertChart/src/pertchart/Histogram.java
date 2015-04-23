/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.ui.ApplicationFrame;

/**
 * An example found here:
 * http://java2s.com/Code/Java/Chart/JFreeChartXYSeriesDemo3.htm
 *
 * @author zac
 */
public class Histogram extends ApplicationFrame {

    private double[] data;
    private int bins;
    
    public Histogram(final String title, double[] data, int bins) {
        super(title);
        this.data = data;
        this.bins = bins;
    }

    public JFreeChart createHistorgram(double[] data) {
        
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.RELATIVE_FREQUENCY);
        dataset.addSeries("Histogram", data, this.bins);
        String plotTitle = "Project Completion Times";
        String xaxis = "Completion Times";
        String yaxis = "";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis,
                    dataset, orientation, show, toolTips, urls);
        int width = 500;
        int height = 300;
        try {
            ChartUtilities.saveChartAsPNG(new File("histogram.png"), chart, width, height);
        } catch (Exception e) {
            System.out.println(e);
        }
        return chart;
    }
    
    public void saveChart() {
        JFreeChart chart = createHistorgram(this.data);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);
    }
}
