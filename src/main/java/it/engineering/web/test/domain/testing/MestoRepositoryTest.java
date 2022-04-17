package it.engineering.web.test.domain.testing;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.repository.*;


public class MestoRepositoryTest {
	public static void main(String[] args) {
		MestoRepositoryImpl mestoRepository= MestoRepositoryImpl.getInstance();
		Mesto mesto1 = new Mesto(11000,"Beograd");
		Mesto mesto3 = new Mesto(4L,13000," merge izmenjen");
		mestoRepository.saveOrUpdate(mesto3);
//		mestoRepository.delete(2L);
		System.out.println(mesto1);
	}
}
