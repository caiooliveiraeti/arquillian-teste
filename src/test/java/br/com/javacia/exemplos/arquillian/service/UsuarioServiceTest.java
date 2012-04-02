package br.com.javacia.exemplos.arquillian.service;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.performance.annotation.Performance;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.javacia.exemplos.arquillian.model.Usuario;
import br.com.javacia.exemplos.arquillian.service.exception.UsuarioSenhaException;

@PersistenceTest
@RunWith(Arquillian.class)
public class UsuarioServiceTest {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackages(true, "br.com.javacia.exemplos.arquillian")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsResource("datasets", "datasets")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	UsuarioService usuarioService;

	@Test
	@Performance(time = 1000)
	@UsingDataSet({ "usuarios.yml" })
	public void testTrocarSenha() {
		Usuario usuario = usuarioService.recuperarPorEmail("caio@javacia.com.br");
		
		try {
			System.out.println("Caio Caio Caio");
			System.out.println(System.getProperty("user.dir"));
			usuarioService.trocarSenha(usuario, "10", "302010");
			Assert.fail("Não validou a senha atual.");
		} catch (UsuarioSenhaException e) {
			Assert.assertEquals("Senha atual inválida.", e.getMessage());
		}
		
		usuarioService.trocarSenha(usuario, "102030", "123456");
		
	}
}
