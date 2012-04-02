package br.com.javacia.exemplos.arquillian.service;

import java.util.List;

import javax.inject.Inject;

import br.com.javacia.exemplos.arquillian.model.Usuario;
import br.com.javacia.exemplos.arquillian.repository.UsuarioRepository;
import br.com.javacia.exemplos.arquillian.service.exception.UsuarioSenhaException;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	@Inject
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void trocarSenha(Usuario usuario, String senhaAtual, String senhaNova) {

		if (usuario.getSenha().equals(senhaAtual)) {
			usuario.setSenha(senhaNova);
			usuarioRepository.salvar(usuario);
		} else {
			throw new UsuarioSenhaException("Senha atual inválida.");
		}

	}

	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.listarTodosUsuarios();
	}

	public Usuario recuperarPorEmail(String email) {
		return usuarioRepository.recuperarPorEmail(email);
	}

}
