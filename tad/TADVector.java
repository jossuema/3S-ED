package tad;

import java.util.Arrays;

public class TADVector<T> {
	private T[] vector;
	private int longitud;
	private String nombre;
	
	@SuppressWarnings("unchecked")
	public TADVector(String nombre, int longitud) {
		super();
		vector = (T[]) new Object[longitud];
		this.longitud = longitud;
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLongitud() {
		return longitud;
	}

	@Override
	public String toString() {
		return "TADVector [vector=" + Arrays.toString(vector) + ", longitud=" + longitud + ", nombre=" + nombre + "]";
	}
	
	public boolean ingresarElemento(int pos, T dato) {
		boolean resul = false;
		boolean posOk = true;
	
		do {
			if(pos>=0 && pos<=vector.length-1) {
				if(vector[pos]==null) {
					vector[pos] = dato;
					resul = true;
				}
				else
					pos++;					
			}
			else
				posOk = false;
		}while(!resul && posOk);
		
		return resul;
	}
	
	public boolean ingresarElemento(T dato) {
		return ingresarElemento(0, dato);
	}
	
	public T leerElemento(int pos) {
		if(pos>=0 && pos<=vector.length-1)
			return vector[pos];
		else
			return null;
	}
	
	public void imprimirVector() {
		for(T elem : vector)
			if(elem != null)
				System.out.println(elem);
	}
	
	public void imprimirVectorCompleto() {
		for(int pos=0; pos<vector.length; ++pos)
			System.out.println(pos + ": " + leerElemento(pos));
	}
	
	public boolean modificarElemento(T dato, int pos) {
		boolean resul = false;
		
		if(pos>=0 && pos<=vector.length-1 && vector[pos]!=null) {
			vector[pos] = dato;
			resul = true;
		}		
		return resul;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(null, pos);
	}
	
}
