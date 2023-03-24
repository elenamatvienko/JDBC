import java.util.List;

public interface EmployeeDAO {

        void create(Employee employee);

        Employee readById(int id);

        List<Employee> readAll();

        void upDateEmployee(Employee employee);

        void deleteEmployee(Employee employee);

    }


