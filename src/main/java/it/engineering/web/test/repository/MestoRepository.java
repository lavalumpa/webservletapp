package it.engineering.web.test.repository;

import java.util.List;

import it.engineering.web.test.domain.Mesto;

public interface MestoRepository {

	void saveOrUpdate(Mesto mesto);

	Mesto findById(Long id);

	void deleteById(Long id);

	List<Mesto> findAll();

	

}