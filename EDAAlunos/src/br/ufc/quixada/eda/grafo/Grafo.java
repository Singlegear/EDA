package br.ufc.quixada.eda.grafo;

public class Grafo {
	// ##### Atributos #####
	public int n; // Quantidade de v�rtices
	public int m; // Quantidade de arestas
	Aresta[] arestas = null; // Array de arestas
	
	// ##### M�todos auxiliares ####
	public Grafo(int n, int m){
		this.setN(n);
		this.setM(m);
		this.arestas = new Aresta[m];
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}	
	public Aresta[] getArestas() {
		return arestas;
	}
	public void setArestas(Aresta[] arestas) {
		this.arestas = arestas;
	}
	public void quickSort(int ini, int fim){
        if (ini < fim) {
            int posicaoPivo = particiona(ini, fim);
            quickSort(ini, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }
	}

	private int particiona(int p, int r){		
        int pivo = p;
        int i = p + 1, f = r;

        while (i <= f) {
            if (arestas[i].getW() <= arestas[pivo].getW())
                i++;
            else if (arestas[pivo].getW() < arestas[f].getW())
                f--;
            else {
                Aresta troca = arestas[i];
                arestas[i] = arestas[f];
                arestas[f] = troca;
                i++;
                f--;
            }
        }
        Aresta troca = arestas[p];
        arestas[p] = arestas[f];
        arestas[f] = troca;
        		
        return f;
    }
	
}
