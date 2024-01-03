package software.ulpgc;

import javax.swing.*;
import java.awt.*;

public class JFreeChartHistogramDisplay extends JFrame implements HistogramDisplay{

    private final Histogram histogram;

    public JFreeChartHistogramDisplay(Histogram histogram) throws HeadlessException {
        this.histogram = histogram;
        this.configure();
        this.add(new HistogramPanel(histogram));
    }

    private void configure() {
        this.setTitle("HistogramDisplay");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void display() {
        this.setVisible(true);
    }
}
