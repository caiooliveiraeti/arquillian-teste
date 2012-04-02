package br.com.javacia.exemplos.arquillian.infrastructure.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.javacia.exemplos.arquillian.model.Usuario;
import br.com.javacia.exemplos.arquillian.repository.UsuarioRepository;

public class UsuarioDao implements UsuarioRepository {

	private EntityManager entityManager;

	@Inject
	public UsuarioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void salvar(Usuario usuario) {

		if (usuario.getId() != null) {
			entityManager.persist(usuario);
		} else {
			entityManager.merge(usuario);
		}

	}

	@Override
	public List<Usuario> listarTodosUsuarios() {
		TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.listarTodosUsuarios", Usuario.class);
		return query.getResultList();
	}

	@Override
	public Usuario recuperarPorEmail(String email) {
		TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.recuperarPorEmail", Usuario.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}

}
