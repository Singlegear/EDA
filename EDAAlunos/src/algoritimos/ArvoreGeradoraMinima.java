package algoritimos;
// Luis Henrique 
// Clayton
import java.util.ArrayList;
import java.util.List;

import conjuntodisjunto.ConjuntoDisjunto;
import grafo.Aresta;
import grafo.Grafo;

public class ArvoreGeradoraMinima {
	
	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getN());
		for(int i = 0; i < g.getN(); i++){
			conj.makeSet(i);
		}
		
		g.quickSort(0, g.getArestas().length - 1);
		
		for(int i = 0; i < g.getM(); i++){
			Aresta a = g.getArestas()[i];
			if(conj.findSetIntel(a.getV()) != conj.findSetIntel(a.getU())){
				solucao.add(a);
				conj.union(a.getV(), a.getU());
			}
		}
		return solucao;
	}
	
	public double getCustoArvore(List<Aresta> solucao){
		double custo = 0;
		for (Aresta aresta : solucao) {
			custo += aresta.getW();
		}
		return custo;
}
}
