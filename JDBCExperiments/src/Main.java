import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "password";

        try {
            Connection connection = DriverManager
                    .getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT courses.id, courses.name AS course_name , \n" +
                            "COUNT(*) AS subscriptions_count \n" +
                            "FROM skillbox.subscriptions JOIN skillbox.students JOIN skillbox.courses\n" +
                            "ON subscriptions.course_id = courses.id \n" +
                            "AND subscriptions.student_id = students.id \n" +
                            "WHERE subscriptions.subscription_date BETWEEN  '2018-01-01 00:00:00' AND '2018-12-31 00:00:00'\n" +
                            "GROUP BY courses.id ORDER BY courses.id;");

            while(resultSet.next()) {
                String id = resultSet.getString("courses.id");
                String name = resultSet.getString("course_name");
                String count = resultSet.getString("subscriptions_count");
                String averageCount = String.valueOf(Double.parseDouble(count)/12);
                String output = "id ".concat(id).concat("  |  " + name).concat("    | subscriptions per month: " + averageCount);
                System.out.println(output);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
