package it.engineering.web.test.domain.testing;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.*;


public class MestoRepositoryTest {
	public static void main(String[] args) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		MestoRepository mestoRepository= new MestoRepositoryImpl(em);
		Mesto mesto1 = new Mesto(11000,"Beograd");
		Mesto mesto3 = new Mesto(4L,13000," merge izmenjen");
		em.getTransaction().begin();
		mestoRepository.saveOrUpdate(mesto3);
//		mestoRepository.delete(2L);
		System.out.println(mesto1);
		em.getTransaction().commit();
	}
}
