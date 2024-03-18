package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class HibernateConnection {
    private static SessionFactory sf;
    private static Logger log = Logger.getLogger(HibernateConnection.class.getName());

    public HibernateConnection() {
    }

    public static SessionFactory getSesionFactory() {
        return sf;
    }

    static {
        try {
            Configuration cf = new Configuration();
            cf.configure("hibernate.cfg.xml");
            sf = cf.buildSessionFactory();
            log.info("SesionFactory created");
        } catch (Exception var1) {
            log.severe("Error al crear SesionFactory");
        }

    }
}
