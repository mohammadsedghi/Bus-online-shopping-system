package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {


    public static final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    public static final Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
    public static final SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
