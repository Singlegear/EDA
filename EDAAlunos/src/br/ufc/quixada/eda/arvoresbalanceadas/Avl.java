package br.ufc.quixada.eda.arvoresbalanceadas;
//Clayton
//Luis Henrique
public class Avl<Chave extends Comparable<Chave>, Info>{
	
	private class No{
		public Chave chave;
		public Info info;
		public No dir, esq;
		public int altura;
		
		public No(Chave chave, Info info){
			this.esq = null;
			this.dir = null;
			this.altura = 1;
			this.chave = chave;
			this.info = info;
		}
	}
	
	private No raiz;
	
	private int altura(No no){
		if(no == null)
			return 0;
		return no.altura;
	}
	private int max(int num1, int num2){
		if(num1 > num2){
			return num1;
		}
		return num2;
	}
	
	private void balancear(No raiz){
		int left = 0;
		int right = 0;
		
		if(raiz.esq != null)
			left = raiz.esq.altura;
		if(raiz.dir != null)
			right = raiz.dir.altura;
			
		if((left - right) == 2){
			if(raiz.esq.esq.altura > raiz.esq.dir.altura){
				raiz = rotacaoDireita(raiz);
			}else {
				raiz = rotacaoDuplaDireita(raiz);
			}
		}
		
		else if((right - left) == 2){
			if(raiz.dir.dir.altura > raiz.dir.esq.altura){
				raiz = rotacaoEsquerda(raiz);
			}else{
				raiz = rotacaoDuplaEsquerda(raiz);
			}
		}
	}
	
	
	private No rotacaoDireita(No noPai){
		No novoNoPai = noPai.esq;
		noPai.esq = novoNoPai.dir;
		novoNoPai.dir = noPai;   
		noPai.altura = max(altura(noPai.dir), altura(noPai.esq)) + 1;
		novoNoPai.altura = max(altura(novoNoPai.dir), altura(novoNoPai.esq)) + 1;
		return novoNoPai;
	}
	
	private No rotacaoEsquerda(No noPai){
		No novoNoPai = noPai.dir;
		noPai.dir = novoNoPai.esq;
		novoNoPai.esq = noPai;
		noPai.altura = max(altura(noPai.dir), altura(noPai.esq)) + 1;
		novoNoPai.altura = max(altura(novoNoPai.dir), altura(novoNoPai.esq)) + 1;
		return novoNoPai;
	}
	
	private No rotacaoDuplaDireita(No noPai){
		noPai.esq = rotacaoEsquerda(noPai.esq);
		return rotacaoDireita(noPai);
	}
	private No rotacaoDuplaEsquerda(No noPai){
		noPai.dir = rotacaoDireita(noPai.dir);
		return rotacaoEsquerda(noPai);
	}
	
	

	//##################### Inserir ############################
	
	public void inserir(Chave chave, Info info){
		this.raiz = inserir(this.raiz, chave, info);
	}
	
	private No inserir(No raiz, Chave chave, Info info){
		if(raiz == null){
			No no = new No(chave, info);
			return no;
		}else if(raiz.chave.compareTo(chave) > 0){
			raiz.esq = inserir(raiz.esq, chave, info);
			balancear(raiz);
		}else if(raiz.chave.compareTo(chave) < 0){
			raiz.esq = inserir(raiz.dir, chave, info);
			balancear(raiz);
		}
		
		raiz.altura = max(altura(raiz.dir), altura(raiz.esq)) + 1;
		
		return raiz;
				
	}
	
	private No find_little(No raiz){
		No no1 = raiz;
		No no2 = raiz.esq;
		
		while(no2 != null){
			no1 = no2;
			no2 = no2.esq;
		}
		
		return no1;
	}

	public void remove(Chave chave){
		this.raiz = remove(raiz, chave);
		balancear(raiz);
	}
	
	private No remove(No raiz, Chave chave){
		if(raiz == null)
			return null;
		
		if(chave.compareTo(raiz.chave) < 0)
			remove(raiz.esq, chave);			
		else if(chave.compareTo(raiz.chave) > 0)
			remove(raiz.dir, chave);
		else{
			if(raiz.esq == null || raiz.dir == null){
				if(raiz.esq != null)
					raiz = raiz.esq;
				else
					raiz = raiz.dir;
			}else{
				No aux = find_little(raiz.dir);
				raiz.chave = aux.chave;
				remove(raiz.dir, raiz.chave);
				balancear(raiz);
			}
		}
		
		return raiz;
	}
	
	private void show(No raiz){
		if(raiz == null)
			return;
		
		System.out.println(raiz.chave);
		
		show(raiz.esq);
		show(raiz.dir);
	}

	public void show(){
		show(raiz);
	}
	
	public static void main(String[] args) {
		Avl<String, String> tree = new Avl<String, String>();
		
		tree.inserir("b", "b");
		tree.inserir("a", "a");
		tree.inserir("c", "c");
		tree.inserir("e", "e");
		tree.inserir("d", "d");
		tree.inserir("f", "f");
		
		tree.show();
		
		tree.remove("e");
		tree.show();
		tree.remove("a");
		tree.show();
	}		
}
