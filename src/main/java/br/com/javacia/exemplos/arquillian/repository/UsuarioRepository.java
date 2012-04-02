package br.com.javacia.exemplos.arquillian.repository;

import java.util.List;

import br.com.javacia.exemplos.arquillian.model.Usuario;

public interface UsuarioRepository {

	void salvar(Usuario usuario);

	List<Usuario> listarTodosUsuarios();

	Usuario recuperarPorEmail(String email);

}
