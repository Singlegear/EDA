package conjuntodisjunto;

public class ConjuntoDisjunto {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	  
	public ConjuntoDisjunto(int n) {
		this.n = n;
		pai = new int[n + 1];
		ordem = new int[n + 1];
	}
	  
	  public void makeSet(int i){
	    pai[i] = i;
	    ordem [i] = 0;	    
	  }
	  
	  public void makeSetAll(){
		  for (int i = 1; i <= n; i++){
			  makeSet(i);
		  }
	  }
	  
	  public int findSet(int v){// fução que não reorganiza
		  if(v == pai[v])
			  return v;
		  
		  return findSet(pai[v]);
	  }
	  
	  public int findSetIntel(int v){//Função que reorganiza
		  if(v == pai[v])
			  return v;
		  pai[v] = findSetIntel(pai[v]);		  
		  return pai[v];		  
	  }
	  
	  public void linkSet(int v, int u){
		  pai[v] = u;
	  }
	  
	  public void linkSetIntel(int v, int u){
		  if (ordem[v] < ordem[u])
			  pai[v] = u;
		  pai[u] = v;
		  if(ordem[u] == ordem[v])
			  ordem[v]++;// precisa incrementar se as orem são iguais, pois a ordem vai almentar em um, não incrementa com ordem diferente pois ele seleciona a menor ordem e coloca na maior, ou seja, a ordem nunca vai ser maior do que a que ja temos.
	  }
	  
	  public void union(int v, int u){// v e u podem ser qualquer elemento do conjuto;
		  linkSet(findSet(v), findSet(u));		  	  
	  }
	  
	  public void unionIntel(int v, int u){// v e u podem ser qualquer elemento do conjuto;
		  linkSetIntel(findSetIntel(v), findSetIntel(u));		  	  
	  }
}