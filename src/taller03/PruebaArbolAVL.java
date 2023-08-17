package taller03;

import arbolBinario.Arbol;
import arbolBinario.ArbolAVL;
import arbolBinario.NodoArbol;
import tadCola.Cola;
import tadCola.TadCola;

public class PruebaArbolAVL {
	public static void main(String[] args) {
		ArbolAVL<Integer> arbol1 = new ArbolAVL<>();
		ArbolAVL<String> arbol2 = new ArbolAVL<>();
		ArbolAVL<Libro> arbol3 = new ArbolAVL<>("Arbol de Libros");
		
		arbol1.insertar(65);
		arbol1.insertar(50);
		arbol1.insertar(23);
		arbol1.insertar(70);
		arbol1.insertar(82);
		arbol1.insertar(68);
		arbol1.insertar(39);
		arbol1.info();
		arbol1.insertar(10);
		arbol1.insertar(43);
		arbol1.insertar(59);
		arbol1.insertar(66);
		
		System.out.println("Se elimina el 82");
		arbol1.eliminar(82);
		arbol1.info();
		
		System.out.println("Se elimina el 10");
		arbol1.eliminar(10);
		arbol1.info();
		
		System.out.println("Se elimina el 39");
		arbol1.eliminar(39);
		arbol1.info();
		
		System.out.println("Se elimina la raiz");
		arbol1.eliminar(arbol1.getRaiz().getClave());
		arbol1.info();
		
		//AVL2
		arbol2.insertar("carrera");
		arbol2.insertar("de");
		arbol2.insertar("Ingenieria");
		arbol2.insertar("en");
		arbol2.insertar("Tecnologias");
		arbol2.insertar("de");
		arbol2.insertar("la");
		arbol2.insertar("Informacion");
		arbol2.info();
		
		System.out.println(colaPreOrder(arbol1));
		
		System.out.println("Ingreso de libros al " +arbol3.getNombre());
		arbol3.insertar(new Libro("Biblia", 700));
		arbol3.insertar(new Libro("Estrcuturas de datos", 300));
		arbol3.insertar(new Libro("Don Quijote de la Mancha", 500));
		arbol3.insertar(new Libro("Ciencia de datos", 200));
		arbol3.insertar(new Libro("De La Tierra A La Luna", 20));
		arbol3.info();
	}
	
	public static <T extends Comparable<T>> Cola<T> colaPreOrder(Arbol<T> arbol){
		Cola<T> cola = new TadCola<>("Cola del metodo recursivo");
		colaPreOrder(arbol.getRaiz(), cola);
		return cola;
	}
	
	/**
	 * Recorrer 
	 * @param <T>
	 * @param arbol
	 */
	public static <T extends Comparable<T>> void colaPreOrder(NodoArbol<T> arbol, Cola<T> cola) {
		if(arbol!=null) {
			cola.encolar(arbol.getClave());
			colaPreOrder(arbol.getIz(), cola);
			colaPreOrder(arbol.getDe(), cola);
		}
	}
}
