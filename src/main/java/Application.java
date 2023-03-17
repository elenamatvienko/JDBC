import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Задание 1
public class Application {
    public static void main(String[] args) throws SQLException {


        final String user = "postgres";
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

                /*System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(city);*/
            }

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);


            City city = new City(4, "city_name");
            Employee employee1 = new Employee
                    (7, "Egor", "Egorov", "male", 35, city.getCity_id());
            Employee employee2 = new Employee
                    (8, "Roman", "Somov", "male", 65, city.getCity_id());
            employeeDAO.create(employee1);
            System.out.println(employee1);
            System.out.println();

            System.out.println(employeeDAO.readById(4));
            System.out.println();

            employeeDAO.upDateEmployeeById(7, employee2);

            employeeDAO.deleteById(2);

            List<Employee> list = new ArrayList<>(employeeDAO.readAll());
            for (Employee employee : list) {
                System.out.println(employee);




            }

        }
    }
}



