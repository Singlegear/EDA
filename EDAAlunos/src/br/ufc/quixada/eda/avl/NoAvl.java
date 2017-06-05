package br.ufc.quixada.eda.avl;

public class NoAvl {
	
	private NoAvl esquerda, direita;
	private int altura, chave;
	
	public NoAvl(int chave){
		this.esquerda = null;
		this.direita = null;
		this.altura = 1;
		this.chave = chave;
	}

	public NoAvl getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoAvl esquerda) {
		this.esquerda = esquerda;
	}

	public NoAvl getDireita() {
		return direita;
	}

	public void setDireita(NoAvl direita) {
		this.direita = direita;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
	
	
}
