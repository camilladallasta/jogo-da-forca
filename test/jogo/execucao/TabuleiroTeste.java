package jogo.execucao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jogo.excecao.EnforcadoException;

public class TabuleiroTeste {
	
	private Tabuleiro tabuleiro;
	
	@BeforeEach
	void geraTabuleiro() {
		tabuleiro = new Tabuleiro(4);
	}
	
	@Test
	void objetivoNaoAlcancadoLetraMinuscula() {
		Palavra palavra = new Palavra();
		palavra.gerarIncognita(1);
		String palavraGerada = palavra.getPalavra();
		String letra = "z";
		boolean verificacao = true;
		
		for(int i = 0; i < palavraGerada.length(); i++) {
			verificacao = palavra.lacunas.get(i).matchLetra(letra);
		}
		
		assertFalse(verificacao);
	}
	
	@Test
	void objetivoNaoAlcancadoLetraMaiuscula() {
		Palavra palavra = new Palavra();
		palavra.gerarIncognita(1);
		String palavraGerada = palavra.getPalavra();
		String letra = "Z";
		boolean verificacao = true;
		
		for(int i = 0; i < palavraGerada.length(); i++) {
			verificacao = palavra.lacunas.get(i).matchLetra(letra);
		}
		
		assertFalse(verificacao);
	}
	
	@Test
	void objetivoAlcancadoLetraMinuscula() {
		Palavra palavra = new Palavra();
		palavra.gerarIncognita(1);
		String palavraGerada = palavra.getPalavra().toLowerCase();
		String letra;
		
		for(int i = 0; i < palavraGerada.length(); i++) {
			letra = Character.toString(palavraGerada.charAt(i));
			palavra.lacunas.get(i).matchLetra(letra);
		}
		
		assertTrue(tabuleiro.objetivoAlcancado());		
	}

	@Test
	void objetivoAlcancadoLetraMaiuscula() {
		Palavra palavra = new Palavra();
		palavra.gerarIncognita(1);
		String palavraGerada = palavra.getPalavra().toUpperCase();
		String letra;
		
		for(int i = 0; i < palavraGerada.length(); i++) {
			letra = Character.toString(palavraGerada.charAt(i));
			palavra.lacunas.get(i).matchLetra(letra);
		}
		
		assertTrue(tabuleiro.objetivoAlcancado());		
	}

	@Test
	void verificarVidasRestantes4() {
		assertTrue(tabuleiro.getVidasRestantes() == 4);
	}
	
	@Test
	void verificarVidasRestantes3() {
		tabuleiro.verificarLetra("");

		assertTrue(tabuleiro.getVidasRestantes() == 3);
	}
	
	@Test
	void verificarVidasRestantes2() {
		tabuleiro.verificarLetra("");
		tabuleiro.verificarLetra("");

		assertTrue(tabuleiro.getVidasRestantes() == 2);
	}	
	
	@Test
	void verificarVidasRestantes1() {
		tabuleiro.verificarLetra("");
		tabuleiro.verificarLetra("");
		tabuleiro.verificarLetra("");

		assertTrue(tabuleiro.getVidasRestantes() == 1);
	}
	
	@Test
	void verificarSeEnforcadoErrado() {		
		Palavra palavra = new Palavra();
		palavra.gerarIncognita(1);
		
		tabuleiro.verificarLetra("");
		tabuleiro.verificarLetra("");
		tabuleiro.verificarLetra("");
		
		boolean todosAbertos = palavra.lacunas.stream().allMatch(l -> l.getAberto());

		assertFalse(todosAbertos);
	}
	
	@Test
	void verificarSeEnforcado() {
				
		boolean todosAbertos = false;
		try {
			Palavra palavra = new Palavra();
			palavra.gerarIncognita(1);
			
			tabuleiro.verificarLetra("");
			tabuleiro.verificarLetra("");
			tabuleiro.verificarLetra("");
			tabuleiro.verificarLetra("");
			
		} catch (EnforcadoException e) {
			todosAbertos = true;
		}

		assertTrue(todosAbertos);
	}
	
}
