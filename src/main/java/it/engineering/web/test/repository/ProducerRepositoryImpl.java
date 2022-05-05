package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.web.test.domain.Producer;

@Repository
public class ProducerRepositoryImpl implements ProducerRepository {
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public void saveOrUpdate(Producer producer) {
		em.merge(producer);

	}

	@Override
	public Producer findById(Long id) {
		return em.find(Producer.class, id);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		Producer production = em.find(Producer.class, id);
		em.remove(production);
		
	}
	
	@Override
	public List<Producer> findAll(){
		String query="SELECT p FROM producer p  ";
		return em.createQuery(query,Producer.class).getResultList();
	}
	
	
}
