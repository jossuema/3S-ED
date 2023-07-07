package Algoritmos;

import tadPila.Pila;
import tadPila.PilaVacia;

public class AlgortimosPilas {
	
	public static <T> int contarPila(Pila<T> pila) throws PilaVacia{
		int result = 0;
		T elem;
		
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			result = 1 + contarPila(pila);
			pila.apilar(elem);
		}
		
		return result;
	}
	
	public static <T> void sumergir(Pila<T> pila, T dato) throws PilaVacia{
		T elem;
		
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			sumergir(pila, dato);
			pila.apilar(elem);
		}else {
			pila.apilar(dato);
		}
		
	}


}
