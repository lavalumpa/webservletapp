package it.engineering.web.test.domain.repository;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class MestoRepository {
	public void saveOrUpdate(Mesto mesto) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(mesto);
		System.out.println(mesto);
		em.getTransaction().commit();
	}
	
	public Mesto findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(Mesto.class, id);
	}
	public void delete(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Mesto mesto =em.find(Mesto.class, id);
		em.getTransaction().begin();
		em.remove(mesto);
		em.getTransaction().commit();
	}
}
