package jogo.bancoPalavras;

import java.util.Random;


public class NivelMedio {
	
	private final String dificuldade = "Medio";
	
	private String palavra;
	private String dica;	
	
	public NivelMedio(){
		
		//sortear um numero, criar switch case e escolher a categoria
		Random randomCategoria = new Random();
		int categoria = randomCategoria.nextInt(2);
		sortearCategoria(categoria);		
	}
	
	
	private void sortearCategoria(int categoria) {
		
		switch(categoria){
		case 0:
			animais();
			break;
			
		case 1:
			objeto();
			break;
		}
		
	}
	
	
	private void animais() {
		
		String Animais[] = {"AVESTRUZ", "CAMALEAO", "FLAMINGO", "GUAXINIM", "JARARACA", "LIBELULA", "MOSQUITO", "PIRARUCU", "SERPENTE", "TAMANDUA"};
		
		dica = "É um animal.";
		
		//sorteando o indice pra achar a palavra dentro da categoria
		Random randomPalavra = new Random();
		int qtdPalavras = Animais.length - 1;
		int aux = randomPalavra.nextInt(qtdPalavras);
		palavra = Animais[aux];	
		
	}
	
	
	private void objeto() {		
		
		String Objeto[] = {"ALFINETE", "CAMISETA", "CARIMBO", "ESPELHO", "GUITARRA", "LANTERNA", "MOCHILA", "PULSEIRA", "RELOGIO", "TESOURA"};
		
		dica = "É um objeto.";
		
		
		//sorteando o indice pra achar a palavra dentro da categoria
		Random randomPalavra = new Random();
		int qtdPalavras = Objeto.length - 1;
		int aux = randomPalavra.nextInt(qtdPalavras);
		palavra = Objeto[aux];	
		
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public String getDica() {
		return dica;
	}
	
	public String toString() {
		return "Nível escolhido: " + dificuldade;
	}

}
