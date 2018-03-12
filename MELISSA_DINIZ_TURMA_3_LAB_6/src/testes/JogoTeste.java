package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lab6.AtributoInvalidoRuntimeException;
import lab6.Jogo;
import lab6.RPG;

public class JogoTeste {

	@Test
	public void testeConstrutorValido() throws Exception {
		Jogo jogoSemEstilo = new RPG("Super Mario", 30.0);
		assertEquals("Super Mario", jogoSemEstilo.getNome());
		assertEquals(30.0, jogoSemEstilo.getPreco(), 0.0);
		assertEquals(0, jogoSemEstilo.getQntVezesZerou());
		assertEquals(0, jogoSemEstilo.getMaiorScore());

		Jogo jogoComEstilo = new RPG("Super Mario", 30.0);
		assertEquals("Super Mario", jogoComEstilo.getNome());
		assertEquals(30.0, jogoComEstilo.getPreco(), 0);
		assertEquals(0, jogoComEstilo.getQntVezesJogou());
		assertEquals(0, jogoComEstilo.getQntVezesZerou());
		assertEquals(0, jogoComEstilo.getMaiorScore());

	}

	@Test
	public void testeConstrutorInvalido() throws Exception {
		try {
			new RPG("", 30.0);
			fail("Deveria gerar AtributoInvalidoRuntimeException");
		} catch (AtributoInvalidoRuntimeException iave) {
			assertEquals("Nome nao pode ser vazio.", iave.getMessage());
		}
		try {
			new RPG("Super Mario", -1.2);
			fail("Deveria gerar AtributoInvalidoRuntimeException");
		} catch (AtributoInvalidoRuntimeException iave) {
			assertEquals("Preco nao pode ser negativo.", iave.getMessage());
		}

	}

}
