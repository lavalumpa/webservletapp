package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;

public class MestoRepositoryImpl implements MestoRepository {
	private static MestoRepository instance;

	private MestoRepositoryImpl() {
	};

	@Override
	public void saveOrUpdate(Mesto mesto,EntityManager em) {
		em.merge(mesto);
	}

	@Override
	public Mesto findById(Long id, EntityManager em) {
		
		return em.find(Mesto.class, id);
	}

	@Override
	public void deleteById(Long id, EntityManager em) {
		Mesto mesto = em.find(Mesto.class, id);
		em.remove(mesto);
	}

	public static MestoRepository getInstance() {
		if (instance == null) {
			instance = new MestoRepositoryImpl();
		}
		return instance;
	}

	@Override
	public List<Mesto> findAll(EntityManager em) {
		String query = "SELECT m FROM mesto m ";
		List<Mesto> mesta = em.createQuery(query).getResultList();
		return mesta;
	}
}
