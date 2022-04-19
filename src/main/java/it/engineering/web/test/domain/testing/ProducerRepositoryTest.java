package it.engineering.web.test.domain.testing;

import javax.persistence.EntityManager;

import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

public class ProducerRepositoryTest {
	public static void main(String[] args) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		ProducerRepository prodRepository =new ProducerRepositoryImpl(em);
		em.getTransaction().begin();
		System.out.println(prodRepository.findById(1L));
//		Mesto mesto3 = new Mesto(4L,"13000","Beograd merge izmenjen");
//		MestoRepository mestoRepository = new MestoRepositoryImpl(em);
//		Mesto mesto = mestoRepository.findById(8L);
//		Producer producer = new Producer("12345678", "123456789", "Ponata", mesto);
//		prodRepository.saveOrUpdate(producer);
		System.out.println(prodRepository.findAll());
		em.getTransaction().commit();
	}
}
