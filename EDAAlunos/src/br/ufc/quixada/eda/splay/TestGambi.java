package br.ufc.quixada.eda.splay;

public class TestGambi {

	public static void main(String[] args) {
		Splay tree = new Splay();
		
		
		tree.inserir(27, "Gambi linda");
		tree.inserir(49, "Gambi linda");
		tree.inserir(10, "Gambi linda");
		tree.inserir(8, "Gambi linda");
		tree.inserir(67, "Gambi linda");
		tree.inserir(15, "Gambi Master linda");
		tree.inserir(59, "Gambi linda");
		tree.inserir(9, "Gambi linda");
		tree.inserir(13, "Gambi linda");
		tree.inserir(20, "Gambi linda");
		tree.inserir(14, "Gambi linda");
		System.out.println(tree.getRaiz().getObjeto());		

	}

}
