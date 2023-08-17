package taller03;

public class Libro implements Comparable<Libro>{
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", numPaginas=" + numPaginas + "]";
	}
	public Libro(String titulo, int numPaginas) {
		super();
		this.titulo = titulo;
		this.numPaginas = numPaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	private String titulo;
	private int numPaginas;
	
	@Override
	public int compareTo(Libro o) {
		if(this.numPaginas > o.getNumPaginas()) {
			return 1;
		}else {
			if(this.numPaginas < o.getNumPaginas()) {
				return -1;
			}else {
				return this.titulo.compareTo(o.getTitulo());
			}
		}
	}
}
