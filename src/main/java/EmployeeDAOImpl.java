import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {

   /* private Connection connection;

    public EmployeeDAOImpl() {
        this.connection = connection;
    }*/

    @Override
    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public Employee readById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);

        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return null;
    }

    @Override
    public List<Employee> readAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();


        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return null;
    }




    @Override
    public void upDateEmployee(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
