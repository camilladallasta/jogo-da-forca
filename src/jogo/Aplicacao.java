package jogo;
import jogo.execucao.Tabuleiro;
import jogo.visao.Console;

public class Aplicacao {
	
	public static void main(String[] args) {
				
		Tabuleiro tabuleiro = new Tabuleiro(4);
		new Console(tabuleiro);
	}

}
