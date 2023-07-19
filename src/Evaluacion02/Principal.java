package Evaluacion02;
import Algoritmos.Algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Principal {

	public static void main(String[] args){
		Cola<Integer> cola = new TadCola<>("COLA");
		
		//cola
		for(int i=1; i<=5; ++i) {
			cola.encolar(Algoritmos.aleatorio(1, 20));
		}
		cola.imprimirCola();
		System.out.println("El �ltimo pasa a ser primero");
		deUltimoAPrimero(cola);
		cola.imprimirCola();		
	}
	
	public static <T> void deUltimoAPrimero(Cola<T> cola){
		T elem;
		try {
			elem = elemUltimo(cola);
			cola.encolar(elem);
			cola.invertirCola();
		} catch (ColaVacia e) {
			System.out.println("Ha ocurrido un error");
		}
		
		if(cola.colaVacia()) {
			System.out.println("Error: La cola esta vacia");
		}
	}
	
	public static <T> T elemUltimo(Cola<T> cola) throws ColaVacia {
		T elem = cola.desencolar();
		T aux;
		
		if(!cola.colaVacia()) {
			aux = elemUltimo(cola);
			cola.encolar(elem);
		}else {
			aux = elem;
		}
		
		return aux;
	}
	
}
