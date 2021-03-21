package jogo.execucao;

import java.util.ArrayList;
import java.util.List;

import jogo.excecao.EnforcadoException;

public class Tabuleiro {
	
	public int dificuldade;
	private int vidas;
	private int vidasRestantes;
	private boolean letraCorreta;
	
	List<String> alfabeto = new ArrayList<String>();
	Palavra incognita = new Palavra();
	
	public Tabuleiro(int vidas) {
		this.vidas = vidas;
		vidasRestantes = vidas;
			
	}
	/*
	public void criarPalavra() {
		incognita 
	}
	*/
	
	
	private void gerarAlfabeto() {
		int i = 0;
		for(char l = 'a'; l <= 'z'; l++) {
			alfabeto.add(i, Character.toString(l));
			i++;
		}		
	}			
	
	//retira do alfabeto a letra digitada
	private void letrasDisponiveis(String letraDigitada) {
		alfabeto.removeIf(l -> l.equalsIgnoreCase(letraDigitada));
	}
	
	
	public String getAlfabeto() {
		
		StringBuilder alfa = new StringBuilder();
		
		for(String letras: alfabeto) {
			alfa.append(" ");
			alfa.append(letras.toUpperCase());
			alfa.append(" ");
		}
		
		return alfa.toString();
		
	}
	
	//verifica se alguma letra da palavra dá match com a letra digitada
	public void verificarLetra(String letraDigitada) {
		//verifica as lacunas iguais e abre elas
		incognita.lacunas.parallelStream().forEach(l -> l.matchLetra(letraDigitada));
		
		// verifica se errou pra descontar vidas
		letraCorreta = incognita.lacunas.stream().anyMatch(l -> l.isCorreto(letraDigitada));
		
		if(!letraCorreta) {
			vidasRestantes--;
			verificarVidas();
		}
		
		letrasDisponiveis(letraDigitada);
	}	
	
	public int getVidasRestantes() {
		return vidasRestantes;
	}
	
	private void verificarVidas() {
		// se zerar as vidas, vai abrir todas as lacunas pra mostrar a palavra no console
		if(vidasRestantes <= 0) {
			incognita.lacunas.stream().forEach(l -> l.setAberto(true));			
			throw new EnforcadoException();

		} else {
			System.out.println("Vidas restantes: " + vidasRestantes);
		}
	}
	
	//vai verificar se cada lacuna foi acertada e aberta
	public boolean objetivoAlcancado() {
		return incognita.lacunas.stream().allMatch(l -> l.objetivoAlcancado());
	}
	
	public void reiniciar() {
		incognita.reiniciar();
		incognita.gerarIncognita(dificuldade);
		vidasRestantes = vidas;
		gerarAlfabeto();
	}
	
	

	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append("DICA: " + incognita.dica);
		sb.append("\n");
		
		switch(vidasRestantes) {		
		case 0:			
			sb.append("____  \n");
			sb.append("|  O  \n");
			sb.append("| ´|` \n");
			sb.append("|  ^  \n");			
			break;
			
		case 1:
			sb.append("____  \n");
			sb.append("|  O  \n");
			sb.append("| ´|` \n");
			sb.append("|     \n");
			break;
			
		case 2:
			sb.append("____  \n");
			sb.append("|  O  \n");
			sb.append("|  |  \n");
			sb.append("|     \n");
			break;
			
		case 3:
			sb.append("____  \n");
			sb.append("|  O  \n");
			sb.append("|     \n");
			sb.append("|     \n");
			break;
			
		case 4:
			sb.append("____  \n");
			sb.append("|     \n");
			sb.append("|     \n");
			sb.append("|     \n");
			break;
		}
		
		sb.append("|      ");
		for(int i = 0; i < incognita.getQuantidadeLetras(); i++) {
			sb.append(incognita.lacunas.get(i));
			sb.append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}

}

