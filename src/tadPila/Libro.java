package tadPila;

import java.io.Serializable;

public class Libro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int numPaginas;
	
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
	@Override
	public String toString() {
		return titulo + " - " + numPaginas;
	}
	public Libro(String titulo, int numPaginas) {
		super();
		this.titulo = titulo;
		this.numPaginas = numPaginas;
	}
	
	
}
