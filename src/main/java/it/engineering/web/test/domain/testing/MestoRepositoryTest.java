package it.engineering.web.test.domain.testing;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.*;


public class MestoRepositoryTest {
	public static void main(String[] args) {
		MestoRepository mestoRepository= MestoRepositoryImpl.getInstance();
		Mesto mesto1 = new Mesto(11000,"Beograd");
		Mesto mesto3 = new Mesto(4L,13000," merge izmenjen");
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		mestoRepository.saveOrUpdate(mesto3,em);
//		mestoRepository.delete(2L);
		System.out.println(mesto1);
		em.getTransaction().commit();
	}
}
