import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {


       /* final String user = "postgres";
        final String password = "Dtc*2023yf";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 4);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String firstName = "First name: " + resultSet.getString("first_name");
                String lastName = "Last name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                String city = "City : " + resultSet.getString("city_id");

                *//*System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(city);*//*
            }*/

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee
                ("Egor", "Egorov", "male", 35,1);
        Employee employee2 = new Employee
                ("Roman", "Somov", "male", 65,1);
           /* employeeDAO.create(employee1);
            System.out.println(employee1);
*/
        System.out.println(employeeDAO.readById(4));

        employeeDAO.upDateEmployee(employee2);

        employeeDAO.deleteEmployee(employee2);

        List<Employee> list = new ArrayList<>(employeeDAO.readAll());
        for (Employee employee : list) {
            System.out.println(employee);

        }

    }
}




