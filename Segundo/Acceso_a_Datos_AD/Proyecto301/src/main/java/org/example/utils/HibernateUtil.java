package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory SESSION_FACTORY;

  static {
    try {
      SESSION_FACTORY = new Configuration()
              .configure()
              .buildSessionFactory();
    } catch (Exception ex) {
      System.err.println("Error al crear la configuración de hibernate: " + ex.getMessage());
      throw new ExceptionInInitializerError(ex);
    }
  }


  public static SessionFactory get() {
    return SESSION_FACTORY;
  }
}
