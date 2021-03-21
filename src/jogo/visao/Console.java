package jogo.visao;

import java.util.Scanner;

import jogo.excecao.EnforcadoException;
import jogo.excecao.SairException;
import jogo.execucao.Tabuleiro;

public class Console {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public Console(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}
	
	private void executarJogo() {				
		try {		
			boolean continuar = true;
			
			while(continuar) {
				
				System.out.println("NIVEL DE DIFICULDADE: ");
				System.out.println("1 - Fácil ");
				System.out.println("2 - Médio ");
				System.out.println("3 - Avançado ");
				System.out.print("Qual você aguenta? ");
				String lerDificuldade = entrada.nextLine();
				tabuleiro.dificuldade = Integer.parseInt(lerDificuldade);
				tabuleiro.reiniciar();
				
				cicloJogo();
				
				System.out.print("\n---> Novo Jovo? (S/n) ");
				String resposta = entrada.nextLine();
				//String resposta = "n";
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
					throw new SairException();
				} else {
					tabuleiro.reiniciar();					
				} 
			}
			
		} catch (SairException e) {
			System.out.println("Tchau!");
			
		} finally {
			entrada.close();
		}
	}
	
	
	private void cicloJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println("----------------------------------------------------------------- \n");
				System.out.println(tabuleiro.toString());
				System.out.println("Letras disponíveis: " + tabuleiro.getAlfabeto());
				
				System.out.print("\nQual letra você escolhe? ");
				String letraDigitada = entrada.nextLine();
				tabuleiro.verificarLetra(letraDigitada);
				System.out.println("----------------------------------------------------------------- \n");
			} 
			
			System.out.println(tabuleiro);
			System.out.println("Parabéns! Você ganhou (:");
			
		} catch (EnforcadoException e) {
			System.out.println(tabuleiro);
			System.out.println("Enforcado! ):");
		}
	}
		
}
