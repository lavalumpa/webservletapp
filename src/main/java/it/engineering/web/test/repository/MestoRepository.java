package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;

public interface MestoRepository {

	void saveOrUpdate(Mesto mesto, EntityManager em);

	Mesto findById(Long id, EntityManager em);

	void deleteById(Long id, EntityManager em);

	List<Mesto> findAll(EntityManager em);

	

}