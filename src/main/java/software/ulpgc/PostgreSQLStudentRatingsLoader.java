package software.ulpgc;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PostgreSQLStudentRatingsLoader implements StudentRatingsLoader{
    private final Set<StudentRating> studentRatings = new HashSet<>();
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String query = "select * from studentratings";

    @Override
    public Set<StudentRating> loadStudentRatings() {
        try (Connection connection = DriverManager.getConnection(url, "postgres", "root")){
            queryDatabase(connection.createStatement());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.studentRatings;
    }

    private void queryDatabase(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            this.studentRatings.add(recordToStudentRating(resultSet));
        }
    }

    private StudentRating recordToStudentRating(ResultSet resultSet) throws SQLException {
        return new StudentRating(resultSet.getString("studentdni"), resultSet.getDouble("studentrating"));
    }
}
