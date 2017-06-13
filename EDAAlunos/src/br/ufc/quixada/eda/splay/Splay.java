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
		public void inserir(int chave, E object){
			raiz = inserir(raiz, chave, object);
		}
		
		private No<?> inserir(No<?> raiz, int chave, E object){
			if(raiz == null)
				return new No<E>(chave, object);
			else if(raiz.getChave() > chave){
				raiz.setEsq(inserir(raiz.getEsq(), chave, object));
			}else if(raiz.getChave() < chave){
				raiz.setDir(inserir(raiz.getDir(), chave, object));
			}
			raiz = sPlay(raiz, chave);
			return raiz;
		}
		
		public No<?> getRaiz(){
			return raiz;
		}
}
