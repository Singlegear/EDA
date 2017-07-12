package br.ufc.quixada.eda.avl;

public class Avl <E>{
	
	//###### Atributos #######
	private NoAvl<?> raiz = null;
	
	//###### Metodos Auxiliares ######
	private int altura(NoAvl<?> no){
		if(no == null)
			return -1;
		return no.getAltura();
	}
	private int max(int num1, int num2){
		if(num1 > num2){
			return num1;
		}
		return num2;
	}
	
	private void balancear(NoAvl<?> raiz){
		if((raiz.getEsquerda().getAltura() - raiz.getDireita().getAltura()) == 2){
			if(raiz.getEsquerda().getEsquerda().getAltura() > raiz.getEsquerda().getDireita().getAltura()){
				raiz = rotacaoDireita(raiz);
			}else {
				raiz = rotacaoDuplaDireita(raiz);
			}
		}
		
		else if((raiz.getDireita().getAltura() - raiz.getEsquerda().getAltura()) == 2){
			if(raiz.getDireita().getDireita().getAltura() > raiz.getDireita().getEsquerda().getAltura()){
				raiz = rotacaoEsquerda(raiz);
			}else{
				raiz = rotacaoDuplaEsquerda(raiz);
			}
		}
	}
	
	//###### Metodos das Rotacoes ######
	private NoAvl<?> rotacaoDireita(NoAvl<?> noPai){
		NoAvl<?> novoNoPai = noPai.getEsquerda();
		noPai.setEsquerda(novoNoPai.getDireita());
		novoNoPai.setDireita(noPai);
		noPai.setAltura(max(altura(noPai.getDireita()), altura(noPai.getEsquerda())) + 1);
		novoNoPai.setAltura(max(altura(novoNoPai.getDireita()), altura(novoNoPai.getEsquerda())) + 1);
		return novoNoPai;
	}
	private NoAvl<?> rotacaoEsquerda(NoAvl<?> noPai){
		NoAvl<?> novoNoPai = noPai.getDireita();
		noPai.setDireita(novoNoPai.getEsquerda());
		novoNoPai.setEsquerda(noPai);
		noPai.setAltura(max(altura(noPai.getDireita()), altura(noPai.getEsquerda())) + 1);
		novoNoPai.setAltura(max(altura(novoNoPai.getDireita()), altura(novoNoPai.getEsquerda())) + 1);
		return novoNoPai;
	}
	private NoAvl<?> rotacaoDuplaDireita(NoAvl<?> noPai){
		noPai.setEsquerda(rotacaoEsquerda(noPai.getEsquerda()));
		return rotacaoDireita(noPai);
	}
	private NoAvl<?> rotacaoDuplaEsquerda(NoAvl<?> noPai){
		noPai.setDireita(rotacaoDireita(noPai.getDireita()));
		return rotacaoEsquerda(noPai);
	}
	
	//###### Metodos de Insercao ######
	public void inserir(String chave, E objeto){
		this.raiz = inserir(this.raiz, chave, objeto);
	}

	
	private NoAvl<?> inserir(NoAvl<?> raiz, String chave, E objeto){
		if(raiz == null){
			NoAvl<?> no = new NoAvl<Object>(chave, objeto);
			return no;
		}else if(raiz.getChave().compareTo(chave) > 0){ //raiz.getChave() > chave
			raiz.setEsquerda(inserir(raiz.getEsquerda(), chave, objeto));
			balancear(raiz);
//			if((raiz.getEsquerda().getAltura() - raiz.getDireita().getAltura()) == 2){
//				if(raiz.getEsquerda().getEsquerda().getAltura() > raiz.getEsquerda().getDireita().getAltura()){
//					raiz = rotacaoDireita(raiz);
//				}else {
//					raiz = rotacaoDuplaDireita(raiz);
//				}
//			}
		}else if(raiz.getChave().compareTo(chave) < 0){ //raiz.getChave() < chave
			raiz.setDireita(inserir(raiz.getDireita(), chave, objeto));
			balancear(raiz);
//			if((raiz.getDireita().getAltura() - raiz.getEsquerda().getAltura()) == 2){
//				if(raiz.getDireita().getDireita().getAltura() > raiz.getDireita().getEsquerda().getAltura()){
//					raiz = rotacaoEsquerda(raiz);
//				}else{
//					raiz = rotacaoDuplaEsquerda(raiz);
//				}
//			}
		}
		
		raiz.setAltura(max(altura(raiz.getDireita()), altura(raiz.getEsquerda())) + 1);
		
		return raiz;
				
	}
	
	private NoAvl<?> find_little(NoAvl<?> raiz){
		NoAvl<?> no1 = raiz;
		NoAvl<?> no2 = raiz.getEsquerda();
		
		while(no2 != null){
			no1 = no2;
			no2 = no2.getEsquerda();
		}
		
		return no1;
	}
	
	public void remove(String chave){
		this.raiz = remove(raiz, chave);
		balancear(raiz);
	}
	
	private NoAvl<?> remove(NoAvl<?> raiz, String  chave){
		if(raiz == null)
			return null;
		
		if(chave.compareTo(raiz.getChave()) < 0)
			remove(raiz.getEsquerda(), chave);			
		else if(chave.compareTo(raiz.getChave()) > 0)
			remove(raiz.getDireita(), chave);
		else{
			if(raiz.getEsquerda() == null || raiz.getDireita() == null){
				if(raiz.getEsquerda() != null)
					raiz = raiz.getEsquerda();
				else
					raiz = raiz.getDireita();
			}else{
				NoAvl<?> aux = find_little(raiz.getDireita());
				raiz.setChave(aux.getChave());
				remove(raiz.getDireita(), raiz.getChave());
				balancear(raiz);
			}
		}
		
		return raiz;
	}
	
	
	public void show(){
		show(raiz);
	}
	
	private void show(NoAvl<?> raiz){
		if(raiz == null)
			return;
		
		System.out.println(raiz.getChave());
		
		show(raiz.getEsquerda());
		show(raiz.getDireita());
	}
	
	public static void main(String[] args) {
		Avl tree = new Avl();
		
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