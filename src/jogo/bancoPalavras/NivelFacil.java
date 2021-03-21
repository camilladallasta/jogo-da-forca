package jogo.bancoPalavras;

import java.util.Random;


public class NivelFacil {

	private final String dificuldade = "Fácil";

	private String palavra;
	private String dica;	
	//public Palavra incognita; 
	
	public NivelFacil(){
		
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
		
		String Animais[] = {"ABELHA", "BUFALO", "CASTOR", "GIRINO", "IGUANA", "JAVALI", "MAMUTE", "OVELHA", "SUCURI", "TUCANO"};
		
		dica = "É um animal.";
		
		//sorteando o indice pra achar a palavra dentro da categoria
		Random randomPalavra = new Random();
		int qtdPalavras = Animais.length - 1;
		int aux = randomPalavra.nextInt(qtdPalavras);
		palavra = Animais[aux];	
	}
	
	
	private void objeto() {		
		
		String Objeto[] = {"FUNIL", "GARFO", "JOIA", "LIVRO", "PRATO", "REMO", "SACO", "TRENA", "URNA", "ZIPER"};
		
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
	
	

