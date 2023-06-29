package tad;

import java.util.Arrays;

public class TADVector<T> {
	private T[] vector;
	private int longitud;
	private String nombre;
	
	@SuppressWarnings("unchecked")
	public TADVector(int longitud, String nombre) {
		super();
		this.vector = (T[]) new Object[longitud];
		this.longitud = longitud;
		this.nombre = nombre;
	}

	public T[] getVector() {
		return vector;
	}

	public void setVector(T[] vector) {
		this.vector = vector;
	}

	@Override
	public String toString() {
		return "TADVector [vector=" + Arrays.toString(vector) + ", longitud=" + longitud + ", nombre=" + nombre + "]";
	}

	public int getLongitud() {
		return longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean ingresarElemento(T dato) {
		for (int i = 0; i < vector.length; i++) {
			if(vector[i]==null) {
				vector[i] = dato;
				return true;
			}
		}
		System.out.println("El vector esta lleno!");
		return false;
	}
	
	public boolean ingresarElemento(int pos, T dato) {
		boolean resul = false;
		boolean pasOk=true;
		do {
			if(pos>=0 && pos <=vector.length-1) {
				if(vector[pos]==null) {
					vector[pos]=dato;
					resul=true;
				}else {
					pos++;
				}
			}
			else {
				pasOk = false;
			}
		}while(!resul && pasOk);
		
		return resul;
	}
	
	public T leerElemento(int pos){
		if(pos>=0 && pos <=vector.length-1)return vector[pos];
		return null;
	}
	
	public void imprimirVectorCompleto() {
		for (int i = 0; i < vector.length; i++) {
			System.out.println("["+i+"] "+ vector[i]);	
		}
	}
	
	public void imprimirVector() {
		for (T t : vector) {
			if(t!=null) {
				System.out.println(t);
			}
			
		}
	}
	
	public boolean modificarElemento(T dato, int pos) {
		if(pos>=0 && pos <=vector.length-1 && vector[pos] != null) {
			vector[pos] = dato;
			return true;
		}
		return false;
	}
	
	public boolean eliminarElemento(int pos){
		return modificarElemento(null, pos);
	}
}
