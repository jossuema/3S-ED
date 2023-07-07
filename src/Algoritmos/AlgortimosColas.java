package Algoritmos;

import tadCola.Cola;
import tadCola.ColaVacia;

public class AlgortimosColas {

	public static <T> int contarColaR(Cola<T> cola) throws ColaVacia{
		int result = 0;
		T elem;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			result = 1 + contarColaR(cola);
			cola.encolar(elem);
		}
		return result;
	}
	
	public static <T> int contarCola(Cola<T> cola){
		int result = 0;
		try {
			result = contarColaR(cola);
			cola.invertirCola();
		} catch (ColaVacia e) {
			
		}
		return result;
	}
}
