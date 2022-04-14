package it.engineering.web.test.persistance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private EntityManagerFactory emf;
	private static MyEntityManagerFactory instance;

	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (instance == null) {
			instance = new MyEntityManagerFactory();
		}
		return instance.getEmf();
	}

	private EntityManagerFactory getEmf() {
		return emf;
	}

	public static void closeEntityManagerFactory() {
		if (instance != null) {
			instance.getEmf().close();
		}
	}
}
