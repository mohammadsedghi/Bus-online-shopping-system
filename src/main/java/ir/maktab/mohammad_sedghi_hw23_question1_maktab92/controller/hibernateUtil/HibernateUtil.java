package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    private static final Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
    private static final SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    public static SessionFactory getSessionFactory() {return sessionFactory;}
}
