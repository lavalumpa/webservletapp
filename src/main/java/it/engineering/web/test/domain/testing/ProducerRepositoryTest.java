package it.engineering.web.test.domain.testing;

import javax.persistence.EntityManager;

import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

public class ProducerRepositoryTest {
	public static void main(String[] args) {
		ProducerRepository prodRepository =ProducerRepositoryImpl.getInstance();
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
//		System.out.println(prodRepository.findById(1L,em));
//		Mesto mesto3 = new Mesto(4L,13000,"Beograd merge izmenjen");
		MestoRepository mestoRepository = MestoRepositoryImpl.getInstance();
//		mestoRepository.deleteById(mesto3.getId(),em);
//		Mesto mesto = mestoRepository.findById(8L,em);
//		Producer producer = new Producer(5161671L, 518691068L, "Ponata", mesto);
//		prodRepository.saveOrUpdate(producer,em);
		System.out.println(prodRepository.findAll(em));
		em.getTransaction().commit();
	}
}
