package tadPila;

import Algoritmos.AlgortimosPilas;

public class PruebaTadPila {

	public static void main(String[] args) {
		Pila<Integer> pila1 = new TadPila<>("Pila 1");
		Pila<Libro> pila2 =  new TadPila<>("Pila de libros");
		
		pila1.apilar(2);
		pila1.apilar(5);
		pila1.apilar(3);
		
		pila1.imprimirPila();
		System.out.println(pila1.toString());
		
		try {
			System.out.println("Cima de pila "+pila1.getNombre()+ ": "+pila1.cima());
			System.out.println("Tiene "+ pila1.numElemPila() + " elementos");
			int dato = pila1.desapilar();
			System.out.println("Dato desapilado: "+dato);
			pila1.imprimirPila();
			pila1.decapitar();
			System.out.println("Se ha eliminado la cima");
			pila1.imprimirPila();
			pila1.eliminarPila();
			System.out.println("Se ha borrado la pila");
			pila1.imprimirPila();
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pila2.getNombre());
		pila2.apilar(new Libro("Huasipungo", 200));
		pila2.apilar(new Libro("Sex para dummies", 100));
		pila2.apilar(new Libro("Estructuras de datos", 300));
		pila2.imprimirPila();
		System.out.println(pila2);
		
		try {
			System.out.println("La pila "+pila2.getNombre()+" tiene "+ AlgortimosPilas.contarPila(pila2));
			AlgortimosPilas.sumergir(pila2, new Libro("Hola", 250));
			pila2.imprimirPila();
			System.out.println(pila2.menorDato());
			System.out.println(pila2.busqueda(new Libro("Hola", 250)));
			pila2.imprimirPila();
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
