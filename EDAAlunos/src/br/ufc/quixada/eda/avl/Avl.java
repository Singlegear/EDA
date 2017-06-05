package br.ufc.quixada.eda.avl;

public class Avl {
	
	//###### Atributos #######
	private NoAvl raiz = null;
	
	//###### Metodos Auxiliares ######
	private int altura(NoAvl no){
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
	
	//###### Metodos das Rotacoes ######
	private NoAvl rotacaoDireita(NoAvl noPai){
		NoAvl novoNoPai = noPai.getEsquerda();
		noPai.setEsquerda(novoNoPai.getDireita());
		novoNoPai.setDireita(noPai);
		noPai.setAltura(max(altura(noPai.getDireita()), altura(noPai.getEsquerda())) + 1);
		novoNoPai.setAltura(max(altura(novoNoPai.getDireita()), altura(novoNoPai.getEsquerda())) + 1);
		return novoNoPai;
	}
	private NoAvl rotacaoEsquerda(NoAvl noPai){
		NoAvl novoNoPai = noPai.getDireita();
		noPai.setDireita(novoNoPai.getEsquerda());
		novoNoPai.setEsquerda(noPai);
		noPai.setAltura(max(altura(noPai.getDireita()), altura(noPai.getEsquerda())) + 1);
		novoNoPai.setAltura(max(altura(novoNoPai.getDireita()), altura(novoNoPai.getEsquerda())) + 1);
		return novoNoPai;
	}
	private NoAvl rotacaoDuplaDireita(NoAvl noPai){
		noPai.setEsquerda(rotacaoEsquerda(noPai.getEsquerda()));
		return rotacaoDireita(noPai);
	}
	private NoAvl rotacaoDuplaEsquerda(NoAvl noPai){
		noPai.setDireita(rotacaoDireita(noPai.getDireita()));
		return rotacaoEsquerda(noPai);
	}
	
	//###### Metodos de Insercao ######
	public void inserir(int chave){
		this.raiz = inserir(this.raiz, chave);
	}
	
	
	private NoAvl inserir(NoAvl raiz, int chave){
		if(raiz == null){
			NoAvl no = new NoAvl(chave);
			return no;
		}else if(raiz.getChave() > chave){
			raiz.setEsquerda(inserir(raiz.getEsquerda(), chave));
			if((raiz.getEsquerda().getAltura() - raiz.getDireita().getAltura()) == 2){
				if(raiz.getEsquerda().getEsquerda().getAltura() > raiz.getEsquerda().getDireita().getAltura()){
					raiz = rotacaoDireita(raiz);
				}else {
					raiz = rotacaoDuplaDireita(raiz);
				}
			}
		}else if(raiz.getChave() < chave){
			raiz.setDireita(inserir(raiz.getDireita(), chave));
			if((raiz.getDireita().getAltura() - raiz.getEsquerda().getAltura()) == 2){
				if(raiz.getDireita().getDireita().getAltura() > raiz.getDireita().getEsquerda().getAltura()){
					raiz = rotacaoEsquerda(raiz);
				}else{
					raiz = rotacaoDuplaEsquerda(raiz);
				}
			}
		}
		
		raiz.setAltura(max(altura(raiz.getDireita()), altura(raiz.getEsquerda())) + 1);
		
		return raiz;
				
	}
}
