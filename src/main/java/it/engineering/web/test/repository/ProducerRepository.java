package it.engineering.web.test.repository;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class ProducerRepository {

	public void saveOrUpdate(Producer Production) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(Production);
		em.getTransaction().commit();
	}

	public Producer findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(Producer.class, id);
	}
	
	public void deleteById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Producer production = em.find(Producer.class, id);
		em.getTransaction().begin();
		em.remove(production);
		em.getTransaction().commit();
	}
}
