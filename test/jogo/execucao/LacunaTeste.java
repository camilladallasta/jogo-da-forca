package jogo.execucao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LacunaTeste {

	private Lacuna lacuna;
	
	//BeforeEach = inicializa essa variavel a cada novo teste para evitar erros (nao é obrigado);
	@BeforeEach
	void iniciarLacuna() {
		lacuna = new Lacuna(0, 'c');
	}
		
	@Test
	void letraErrada() {
		String letraDigitada = "a";
		boolean acertou = lacuna.matchLetra(letraDigitada);
		
		assertFalse(acertou);
	}
	
	@Test
	void letraCerta() {
		String letraDigitada = "c";
		boolean acertou = lacuna.matchLetra(letraDigitada);
		
		assertTrue(acertou);
	}
	
	@Test
	void reiniciar() {
		lacuna.reiniciar();
		boolean acertou = lacuna.getAcertou();
		boolean aberto = lacuna.getAberto();
		
		assertFalse(acertou && aberto);
	}
}
