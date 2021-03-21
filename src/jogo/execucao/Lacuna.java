package jogo.execucao;

public class Lacuna {
	
	private int indice;
	private String letra;

	private boolean aberto = false;
	private boolean acertou = false;
	
	public Lacuna(int indice, char letra){
		this.indice = indice;
		this.letra = Character.toString(letra); //converte char pra string
	}
	
	public int getIndice() {
		return indice;
	}
	
	public String getLetra() {
		return letra;
	}
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	private void acertouLetra() {		
		acertou = true;
	}
	
	public boolean matchLetra(String letraDigitada) {
		if(letra.equalsIgnoreCase(letraDigitada)) {
			acertouLetra();	
		}
		return acertou;
	}
	
	public boolean isCorreto(String letraDigitada) {
		if(letra.equalsIgnoreCase(letraDigitada)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean getAcertou() {
		return acertou;
	}
	public boolean getAberto() {
		return aberto;
	}
	
	public boolean objetivoAlcancado() {
		//return aberto && acertou;
		return acertou;
	}
	
	public void reiniciar() {
		aberto = false;
		acertou = false;
	}
	
	public String toString() {		
		if(aberto || acertou) {
			return letra;
		} else {
			return "_";
		}		
	}
}
