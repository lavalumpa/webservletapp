package it.engineering.web.test.repository;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class MestoRepository {
	private static MestoRepository instance;
	
	private MestoRepository() {};
	
	public void saveOrUpdate(Mesto mesto) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(mesto);
		em.getTransaction().commit();
	}

	public Mesto findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(Mesto.class, id);
	}

	public void deleteById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Mesto mesto = em.find(Mesto.class, id);
		em.getTransaction().begin();
		em.remove(mesto);
		em.getTransaction().commit();
	}
	
	public static MestoRepository getInstance() {
		if (instance==null) {
			instance=new MestoRepository();
		}
		return instance;
	}
}
