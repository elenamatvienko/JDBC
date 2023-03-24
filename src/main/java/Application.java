
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
        City city = new City("Rim");
        City city2 = new City(2, "Tomsk");
        Employee danil = new Employee
                ("Danil2", "Danilov", "male", 44, city);
        Employee alisa = new Employee(9, "Alisa", "Alisina", "female", 33, city2);
        cityDAO.create(city);
        employeeDAO.create(danil);
        System.out.println(city);
        System.out.println(danil);
        employeeDAO.upDateEmployee(alisa);
        cityDAO.upDateCity(city2);

        System.out.println(cityDAO.readById(3));
        employeeDAO.deleteEmployee(danil);
        cityDAO.deleteCity(city);

        List<Employee> list = new ArrayList<>(employeeDAO.readAll());
        for (Employee employees : list) {
            System.out.println(employees);

        }

    }
}







