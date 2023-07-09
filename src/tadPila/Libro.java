package tadPila;

import java.io.Serializable;

public class Libro implements Serializable, Comparable<Libro>{
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
	
	/**
	 * Implementa el metodo de comparacion de la interfaz comparable
	 * Devuelve numero positivo si el libro tiene mas paginas que el comparado
	 * Devuelve numero negativo si el libro tiene menos paginas que el comparado
	 * Devuelve 0 si ambos libros tienes las misma paginas
	 */
	@Override
	public int compareTo(Libro o) {
		if(this.titulo.compareTo(o.titulo) == 0) {
			return this.numPaginas - o.numPaginas;
		}
		return this.titulo.compareTo(o.titulo);
	}
	
}
