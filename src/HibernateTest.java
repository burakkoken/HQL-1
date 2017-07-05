import Models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Employee");
        List<Employee> employeeList = query.list();

        System.out.println("employee size : " + employeeList.size());

        for (Employee employee : employeeList) {
            System.out.println("id : " + employee.getId() +
                    ", name : " + employee.getName() +
                    ", salary : " + employee.getSalary()
            );
        }

    }
}
