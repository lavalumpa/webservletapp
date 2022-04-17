package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class ProducerRepositoryImpl implements ProducerRepository {
	private static ProducerRepository instance;
	
	private ProducerRepositoryImpl() {
		
	}

	@Override
	public void saveOrUpdate(Producer Production) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(Production);
		em.getTransaction().commit();
	}

	@Override
	public Producer findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(Producer.class, id);
	}
	
	@Override
	public void deleteById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Producer production = em.find(Producer.class, id);
		em.getTransaction().begin();
		em.remove(production);
		em.getTransaction().commit();
	}
	
	@Override
	public List<Producer> findAll(){
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		String query="SELECT p FROM producer p  ";
		return em.createQuery(query,Producer.class).getResultList();
	}
	
	public static ProducerRepository getInstance() {
		if (instance==null) {
			instance = new ProducerRepositoryImpl();
		}
		return instance;
	}
}
