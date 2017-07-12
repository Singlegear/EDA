package br.ufc.quixada.eda.avl;

public class NoAvl <E>{
	
	private NoAvl<?> esquerda, direita;
	private int altura;
	private E objeto;
	private String chave;
	
	public NoAvl(String chave, E objeto){
		this.esquerda = null;
		this.direita = null;
		this.altura = 1;
		this.chave = chave;
		this.objeto = objeto;
	}

	public NoAvl<?> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoAvl<?> esquerda) {
		this.esquerda = esquerda;
	}

	public NoAvl<?> getDireita() {
		return direita;
	}

	public void setDireita(NoAvl<?> direita) {
		this.direita = direita;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public E getObjeto() {
		return objeto;
	}

	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}
	
	
}
