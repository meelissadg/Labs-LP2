package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lab6.Fachada;
import lab6.RPG;
import usuario.Usuario;

public class FachadaTeste {

	private static Fachada fachada = new Fachada();

	@Test
	public void testeAcriarUsuario() throws Exception {
		Usuario usuario = new Usuario("Eri Jonhson", "ejos");
		assertEquals(0, fachada.quantidadeDeUsuarios());
		assertTrue(fachada.criarUsuario("Eri Jonhson", "ejos"));
		assertTrue(fachada.buscaUsuario(usuario));
		assertEquals(1, fachada.quantidadeDeUsuarios());
		assertFalse(fachada.buscaUsuario(new Usuario("Eri", "eri")));
	}

	@Test
	public void testeRecuperarUsuario() throws Exception {
		Usuario usuario = fachada.buscaUsuarioPorLogin("ejos");
		assertEquals("Eri Jonhson", usuario.getNome());
	}
	
	@Test
	public void testeEvenderJogo() throws Exception {
		assertEquals(00.0, fachada.buscaUsuarioPorLogin("ejos").getDinheiro(), 0.0);
		fachada.depositarNaContaDeUsuario("ejos", 50);
		assertEquals(50.0, fachada.buscaUsuarioPorLogin("ejos").getDinheiro(), 0.0);
		assertEquals(50.0, fachada.buscaUsuarioPorLogin("ejos").getDinheiro(), 0.0);
		Usuario usuario = fachada.buscaUsuarioPorLogin("ejos");
		usuario = fachada.buscaUsuarioPorLogin("ejos");
		assertFalse(usuario.buscajogo(new RPG("Child of Light", 00.00)));
		
	}

	


}
