package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Producer;

public class ProducerRepositoryImpl implements ProducerRepository {
	private EntityManager em;
	
	public ProducerRepositoryImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public void saveOrUpdate(Producer producer) {
		em.merge(producer);

	}

	@Override
	public Producer findById(Long id) {
		return em.find(Producer.class, id);
	}
	
	@Override
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
