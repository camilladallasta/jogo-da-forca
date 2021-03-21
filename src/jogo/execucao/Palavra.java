package jogo.execucao;

import java.util.ArrayList;

import java.util.List;

import jogo.bancoPalavras.NivelAvancado;
import jogo.bancoPalavras.NivelFacil;
import jogo.bancoPalavras.NivelMedio;



public class Palavra {
	
	private int dificuldade;
	private String palavra = "";
	public String dica;
	
	List<Lacuna> lacunas = new ArrayList<Lacuna>();

	
	public void gerarIncognita(int dificuldade){
		this.dificuldade = dificuldade;
		
		switch(this.dificuldade) {
		case 1:
			NivelFacil nivelDificuldade1 = new NivelFacil();
			armazenarPalavra(nivelDificuldade1.getPalavra());
			this.dica = nivelDificuldade1.getDica();
			break;
		
		case 2:
			NivelMedio nivelDificuldade2 = new NivelMedio();
			armazenarPalavra(nivelDificuldade2.getPalavra());
			this.dica = nivelDificuldade2.getDica();
			break;
		
		case 3:
			NivelAvancado nivelDificuldade3 = new NivelAvancado();
			armazenarPalavra(nivelDificuldade3.getPalavra());
			this.dica = nivelDificuldade3.getDica();
			break;
			
		default:
			break;
		}
		
	}
	
	private void armazenarPalavra(String palavra) {
		this.palavra = palavra;
		separarLetras(palavra);
	}
	
	private void separarLetras(String palavra) {
		//System.out.println("palavra recebida: " + palavra);
		
		for(int i = 0; i < palavra.length(); i++) {
			lacunas.add(new Lacuna(i, palavra.charAt(i)));
		}		
	}
	
	
	
	public void reiniciar() {
		//reinicia campos: aberto e acertou
		lacunas.stream().forEach(l -> l.reiniciar());
		//limpa arrayList e depois gera nova palavra
		lacunas.clear();
	}
	
	public int getQuantidadeLetras() {
		return palavra.length();
	}
	
	
	// para testes...
	public String getPalavra() {
		return palavra;
	}
	
	public int getDificuldade() {
		return dificuldade;
	}
	
	public String getDica() {
		return dica;
	}
	
}
