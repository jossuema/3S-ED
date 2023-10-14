package algoritmos;

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

	public static <T> T fondo(Pila<T> pila) throws PilaVacia {
		if(pila.numElemPila()==1) {
			return pila.cima();
		}
		
		T elem = pila.desapilar();
		T res =  fondo(pila);
		pila.apilar(elem);
		
		return res;
		
	}
}
