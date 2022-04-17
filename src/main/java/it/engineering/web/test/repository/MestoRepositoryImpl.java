package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Mesto;

public class MestoRepositoryImpl implements MestoRepository {
	private EntityManager em;

	public MestoRepositoryImpl(EntityManager em) {
		this.em=em;
	};

	@Override
	public void saveOrUpdate(Mesto mesto) {
		em.merge(mesto);
	}

	@Override
	public Mesto findById(Long id) {
		
		return em.find(Mesto.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Mesto mesto = em.find(Mesto.class, id);
		em.remove(mesto);
	}

	

	@Override
	public List<Mesto> findAll() {
		String query = "SELECT m FROM mesto m ";
		List<Mesto> mesta = em.createQuery(query).getResultList();
		return mesta;
	}
}
