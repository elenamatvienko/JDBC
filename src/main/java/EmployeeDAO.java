import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void upDateEmployeeById(int id, Employee employee);

    void deleteById(int id);

}
