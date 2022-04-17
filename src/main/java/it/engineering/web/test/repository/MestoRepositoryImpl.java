package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class MestoRepositoryImpl implements MestoRepository {
	private static MestoRepository instance;

	private MestoRepositoryImpl() {
	};

	@Override
	public void saveOrUpdate(Mesto mesto) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(mesto);
		em.getTransaction().commit();
	}

	@Override
	public Mesto findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(Mesto.class, id);
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Mesto mesto = em.find(Mesto.class, id);
		em.getTransaction().begin();
		em.remove(mesto);
		em.getTransaction().commit();
	}

	public static MestoRepository getInstance() {
		if (instance == null) {
			instance = new MestoRepositoryImpl();
		}
		return instance;
	}

	@Override
	public List<Mesto> findAll() {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		String query = "SELECT m FROM mesto m ";
		List<Mesto> mesta = em.createQuery(query).getResultList();
		return mesta;
	}
}
