package br.ufc.quixada.eda.rubro_negra;

public class RbTree<Chave extends Comparable<Chave>, Info>{
	
	private static final boolean VERMELHO   = true;
    private static final boolean PRETO = false;	
    private No raiz;
    
    private class No {
        public Chave chave;
        public Info info;
        public No esq, dir, pai;
        public boolean cor;

        public No(Chave chave, Info info, boolean cor) {
            this.chave   = chave;
            this.info = info;
            this.cor = cor;
        }
    }
    
	private void left_Rotate(No x){
		No y = new No(x.dir.chave, x.dir.info, x.dir.cor);
		x.dir = y.esq;
		y.esq.pai = x;
		y.pai = x.pai;
		
		if(x.pai == null)
			this.raiz = y;
		else if(x == x.pai.esq)
			x.pai.esq = y;
		else
			x.pai.dir = y;
		
		y.esq = x;
		x.pai = y;
	}
	
	private void right_rotate(No y){
		No x = new No(y.esq.chave, y.esq.info, y.esq.cor);
		y.esq = x.dir;
		x.dir.pai = y;
		x.pai = y.pai;
		
		if(y.pai == null)
			this.raiz = x;
		else if(y == y.pai.esq)
			y.pai.esq = x;
		else
			y.pai.dir = x;
		
		x.dir = y;
		y.pai = x;
	}
	
	private void RB_Insert(No z){
		No y = null;
		No x = raiz;
		
		while(x != null){
			y = x;
			if(z.chave < x.chave)
				x = x.esq;
			else
				x = x.dir;
		}
		
		z.pai = y;
		
		if(y == null)
			this.raiz = z;
		else if(z.chave < y.chave)
			y.esq = z;
		else
			y.dir = z;
		
		z.esq = null;
		z.dir = null;
		z.cor = VERMELHO;
		RB_Insert_FixeUp(z);
	}
	
	private void RB_Insert_FixeUp(No z){
		No y = null;
		while(z.pai.cor == VERMELHO){
			if(z.pai == z.pai.pai.esq){
				y = z.pai.pai.dir;
				if(y.cor == VERMELHO){
					z.pai.cor = PRETO;
					y.cor = PRETO;
					
				}
			}
		}
	}
}
