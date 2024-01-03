package software.ulpgc;

public class TestBDHistogram {
    public static void main(String[] args) {
        StudentRatingsLoader loader = new PostgreSQLStudentRatingsLoader();
        Histogram histogram = new DoubleArrayStudentRatingsHistogram(loader.loadStudentRatings());
        HistogramDisplay display = new JFreeChartHistogramDisplay(histogram);
        display.display();
    }
}
