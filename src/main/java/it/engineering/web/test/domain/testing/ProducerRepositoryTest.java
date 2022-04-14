package it.engineering.web.test.domain.testing;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.ProducerRepository;

public class ProducerRepositoryTest {
	public static void main(String[] args) {
		ProducerRepository prodRepository = new ProducerRepository();
//		System.out.println(prodRepository.findById(1L));
//		Mesto mesto3 = new Mesto(4L,13000,"Beograd merge izmenjen");
		MestoRepository mestoRepository = new MestoRepository();
//		mestoRepository.deleteById(mesto3.getId());
//		Mesto mesto = mestoRepository.findById(8L);
//		Producer producer = new Producer(5161671L, 518691068L, "Ponata", mesto);
//		prodRepository.saveOrUpdate(producer);
		System.out.println(prodRepository.findAll());
	}
}
