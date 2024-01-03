package software.ulpgc;

import java.util.Set;

public class DoubleArrayStudentRatingsHistogram implements Histogram{
    private final Set<StudentRating> studentRatingSet;

    public DoubleArrayStudentRatingsHistogram(Set<StudentRating> studentRatingSet) {
        this.studentRatingSet = studentRatingSet;
    }

    @Override
    public double[] values() {
        return this.studentRatingSet.stream().mapToDouble(StudentRating::rating).toArray();
    }

    @Override
    public int bins() {
        return 5;
    }
}
