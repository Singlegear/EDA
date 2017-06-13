package br.ufc.quixada.eda.splay;


public class Splay <E>{

		private No<?> raiz;
		
		
		private No<?> rotacaoDireita(No<?> noPai){
			No<?> novoPai = noPai.getEsquerda();
			noPai.setEsquerda(novoPai.getDireita());
			novoPai.setDireita(noPai);
			return novoPai;
		}
		private No<?> rotacaoEsquerda(No<?> noPai){
			No<?> novoPai = noPai.getDireita();
			noPai.setDireita(novoPai.getEsquerda());
			novoPai.setEsquerda(noPai);
			return novoPai;
		}
//		private No rotacaoDuplaDireita(No<?> noPai){
//			noPai.setEsquerda(rotacaoEsquerda(noPai.getEsquerda()));
//			return rotacaoDireita(noPai);
//		}
//		private No<?> rotacaoDuplaEsquerda(No<?> noPai){
//			noPai.setDireita(rotacaoDireita(noPai.getDireita()));
//			return rotacaoEsquerda(noPai);
//		}
		
		private No<?> splay(No<?> raiz, int chave){
			if(raiz == null) 
				return null;
			if(raiz.getChave() == chave)
				return raiz;
			
			if(chave < raiz.getChave()){
				if(raiz.getEsquerda() != null){
					raiz.setEsquerda(splay(raiz.getEsquerda(), chave));
					raiz = rotacaoDireita(raiz);
				}
			}else {
				if(raiz.getDireita() != null){
					raiz.setDireita(splay(raiz.getDireita(), chave));
					raiz = rotacaoEsquerda(raiz);
				}
			}
			
			return raiz;
		}
		
		public No<?> busca(int chave){
			raiz = splay(raiz, chave);
			if(raiz.getChave() == chave)
				return raiz;
			else
				return null;
		}
		public No<?> inserir(int chave, E objeto){
			insert(chave, objeto);
			return raiz = splay(raiz, chave);
		}
		private void insert(int chave, E objeto){
			if(raiz == null)
				raiz = new No<Object>(chave, objeto);
			
			raiz = splay(raiz, chave);
			
			if(raiz.getChave() == chave)
				return;
			
			No<?> no = new No<Object>(chave, objeto);
			if(raiz.getChave() > chave){
				no.setEsquerda(raiz.getEsquerda());
				no.setDireita(raiz);
				raiz.setEsquerda(null);
			}else{
				no.setDireita(raiz.getDireita());
				no.setEsquerda(raiz);
				raiz.setDireita(null);
			}
		}
		
		public No<?> getRaiz(){
			return raiz;
		}
}
