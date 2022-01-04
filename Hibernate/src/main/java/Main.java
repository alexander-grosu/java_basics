import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static final Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    private static final SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        List courseList = session.createQuery("FROM " + Course.class.getSimpleName()).getResultList();

        int size = courseList.size();
        int id = 1;

        Course course = session.get(Course.class, id);
        System.out.println("\n" + course.getId() + " " + course.getName() + " | " + course.getType() + "\nstudents count: " + course.getStudentsCount() + "\n");
        while (id < size) {
            id++;
            course = session.get(Course.class, id);
            System.out.println(course.getId() + " " + course.getName() + " | " + course.getType() + "\nstudents count: " + course.getStudentsCount() + "\n");
        }

        session.close();
        sessionFactory.close();
        registry.close();
    }
}
