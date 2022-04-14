package it.engineering.web.test.domain.testing;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.repository.MestoRepository;


public class Testing {
	public static void main(String[] args) {
		MestoRepository mestoRepository= new MestoRepository();
		Mesto mesto1 = new Mesto(11000,"Beograd");
		Mesto mesto3 = new Mesto(3L,13000,"Beograd merge izmenjen");
		mestoRepository.delete(2L);
		System.out.println(mesto1);
	}
}
