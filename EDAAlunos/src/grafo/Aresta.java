package grafo;

public class Aresta {
	// ##### Atributos ####
	public int u; // Vértice
	public int v; // Vértice
	public int w; // Peso da aresta
	
	// #### Métodos auxiliares ####
	public Aresta(int u, int v, int w){
		this.setU(u);
		this.setV(v);
		this.setW(w);
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
}
