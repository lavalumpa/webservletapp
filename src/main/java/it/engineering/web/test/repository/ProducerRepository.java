package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Producer;

public interface ProducerRepository {

	void saveOrUpdate(Producer Production, EntityManager em);

	Producer findById(Long id, EntityManager em);
	
	void deleteById(Long id, EntityManager em);

	List<Producer> findAll(EntityManager em);
}