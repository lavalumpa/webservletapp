package it.engineering.web.test.repository;

import java.util.List;

import it.engineering.web.test.domain.Producer;

public interface ProducerRepository {

	void saveOrUpdate(Producer Production);

	Producer findById(Long id);

	void deleteById(Long id);

	List<Producer> findAll();

}