package tad;

import java.util.ArrayList;

public class TADArreglo<T> {
	private ArrayList<T> arreglo;
	private String nombre;
	
	@SuppressWarnings("unchecked")
	public TADArreglo(String nombre) { //Los arraylist son dinamicos no necesitan ser inicializados con un tamaño fijo
		super();
		this.arreglo = new ArrayList<>();
		this.nombre = nombre;
	}

	public ArrayList<T> getArrelgo() {
		return arreglo;
	}

	public void setArreglo(ArrayList<T> arreglo) {
		this.arreglo = arreglo;
	}

	public int getLongitud() {
		return this.arreglo.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que revisa si hay un espacio null en el arreglo de lo contrario aumenta su tamaño y agrega el elemento
	 * @param dato
	 * @return
	 */
	public boolean ingresarElemento(T dato) {
		for (int i = 0; i < arreglo.size(); i++) {
			if(arreglo.get(i)==null) {
				arreglo.set(i, dato);
				return true;
			}
		}
		arreglo.add(dato);
		return true;
	}
	
	/**
	 * Ingresar elemento en cierta posicion si no esta disponible busca otra disponible
	 * Retorna true si elelemento se ha insertado o false sino
	 * @param pos
	 * @param dato
	 * @return
	 */
	public boolean ingresarElemento(int pos, T dato) {
		boolean resul = false;
		boolean pasOk=true;
		do {
			if(pos>=0 && pos <= arreglo.size()-1) {
				if(arreglo.get(pos)==null) {
					arreglo.set(pos, dato);
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
	
	/**
	 * Busca elemento en la posicion dada. Si la posicion no existe retorna null.
	 * @param pos
	 * @return
	 */
	public T leerElemento(int pos){
		if(pos>=0 && pos <=arreglo.size()-1)return arreglo.get(pos);
		return null;
	}
	
	/**
	 * Imprime todo el vector incluido los null
	 */
	public void imprimirVectorCompleto() {
		for (int i = 0; i < arreglo.size(); i++) {
			System.out.println("["+i+"] "+ arreglo.get(i));	
		}
	}
	
	/**
	 * Imprime solo las posiciones distintas de null
	 */
	public void imprimirVector() {
		for (T t : arreglo) {
			if(t!=null) {
				System.out.println(t);
			}
			
		}
	}
	
	/**
	 * Modifica elemento en una posicion determinada
	 * Si la posicion no existe en el arrglo retorna false y no se edita
	 * Si la posicion en el arreglo es null retorna false y no se edita
	 * @param dato
	 * @param pos
	 * @return
	 */
	public boolean modificarElemento(T dato, int pos) {
		if(pos>=0 && pos <=arreglo.size()-1 && arreglo.get(pos) != null) {
			arreglo.set(pos, dato);
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina el elemento dentro del arreglo y tambien la posicion (El arreglo reduce su tamaño)
	 * Si la posicion dad no existe no sucede nada y retorna false
	 * @param pos
	 * @return
	 */
	public boolean eliminarElemento(int pos){
		if(pos>=0 && pos <=arreglo.size()-1) {
			arreglo.remove(pos);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "TADArreglo [arreglo=" + arreglo + ", nombre=" + nombre + "]";
	}
}
