package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lab6.AtributoInvalidoRuntimeException;
import usuario.Usuario;

public class UsuarioTeste {

	@Test
	public void construtorValido() throws Exception {
		Usuario usuario = new Usuario("Melissa Diniz", "melissadg");
		assertEquals("Melissa Diniz", usuario.getNome());
		assertEquals("melissadg", usuario.getLogin());
		assertEquals(0.0, usuario.getDinheiro(), 0.0);
	}

	@Test
	public void construtorInvalido() throws Exception {
		try {
			new Usuario("", "melissadg");
			fail("Deve lancar AtributoInvalidoRuntimeException.");
		} catch (AtributoInvalidoRuntimeException iave) {
			assertEquals("Nome nao pode ser vazio.", iave.getMessage());
		}
		try {
			new Usuario("Melissa Diniz", "");
			fail("Deve lancar AtributoInvalidoRuntimeException.");
		} catch (AtributoInvalidoRuntimeException iave) {
			assertEquals("Login nao pode ser vazio.", iave.getMessage());
		}
	}
	
}
