package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static HibernateUtil instance = null;

	private EntityManager entityManager;

	public HibernateUtil() {
		entityManager = Persistence.createEntityManagerFactory("QLLK_PhanTan").createEntityManager();
	}

	public synchronized static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;

	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
