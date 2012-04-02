package br.com.javacia.exemplos.arquillian.infrastructure;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

	@PersistenceContext
	private EntityManager entityManager;

	@Produces
	public EntityManager createEntityManager() {
		return entityManager;
	}
}
