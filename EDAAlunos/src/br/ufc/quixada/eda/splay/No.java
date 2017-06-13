package br.ufc.quixada.eda.splay;

public class No <E>{
	
	private No<?> direita, esquerda;
	private int chave;
	private E objeto;
	
	
	public No(int chave, E objeto){
		this.setChave(chave);
		this.setObjeto(objeto);
		this.setDireita(null);
		this.setEsquerda(null);
	}
	public No<?> getDireita() {
		return direita;
	}
	public void setDireita(No<?> direita) {
		this.direita = direita;
	}
	public No<?> getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(No<?> esquerda) {
		this.esquerda = esquerda;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public E getObjeto() {
		return objeto;
	}
	public void setObjeto(E objeto) {
		this.objeto = objeto;
	}
	
	

}
