package software.ulpgc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;

public class HistogramPanel extends JPanel {
    private final Histogram histogram;

    public HistogramPanel(Histogram histogram) {
        this.histogram = histogram;
        this.add(chartHistogramPanel());
    }

    private Component chartHistogramPanel() {
        return new ChartPanel(ChartFactory.createHistogram("Student Ratings Histogram", "Notes", "Counts", dataset(), PlotOrientation.VERTICAL, false, false, false));
    }

    private HistogramDataset dataset() {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("series", this.histogram.values(), this.histogram.bins());
        return dataset;
    }

}
