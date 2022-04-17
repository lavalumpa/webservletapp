package it.engineering.web.test.domain.testing;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

public class ProducerRepositoryTest {
	public static void main(String[] args) {
		ProducerRepositoryImpl prodRepository =ProducerRepositoryImpl.getInstance();
//		System.out.println(prodRepository.findById(1L));
//		Mesto mesto3 = new Mesto(4L,13000,"Beograd merge izmenjen");
		MestoRepositoryImpl mestoRepository = MestoRepositoryImpl.getInstance();
//		mestoRepository.deleteById(mesto3.getId());
//		Mesto mesto = mestoRepository.findById(8L);
//		Producer producer = new Producer(5161671L, 518691068L, "Ponata", mesto);
//		prodRepository.saveOrUpdate(producer);
		System.out.println(prodRepository.findAll());
	}
}
