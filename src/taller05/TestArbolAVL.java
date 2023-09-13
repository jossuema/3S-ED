package taller05;

import arbolBinario.Arbol;
import arbolBinario.ArbolAVL;
import arbolBinario.NodoArbol;

public class TestArbolAVL {

	public static void main(String[] args) {
		ArbolAVL<Persona> arbolAVL = new ArbolAVL<>("MiAVL");
		boolean resul = false;
		long tiempo;
		Persona auxpersona = new Persona("Paul", "0706029188");
		
		Persona persona1 = new Persona("John Bocca", "0721687531");
		Persona persona2 = new Persona("Brian Banegas", "0705297810");
		Persona persona3 = new Persona("Richard Briones", "0700903750");
		Persona persona4 = new Persona("Dennis Rivera", "0718834146");
		Persona persona5 = new Persona("Adi Shumi", "0745348854");
		Persona persona6 = new Persona("Ada Lomas", "0753927813");
		Persona persona7 = new Persona("Linus Torres", "0705355188");
		Persona persona8 = new Persona("Alan Tumbaco", "0724593975");
		Persona persona9 = new Persona("Bill Gallardo", "0733723480");
		Persona persona10 = new Persona("Alan Coronado", "0714372661");
		
		arbolAVL.insertar(persona1);
		arbolAVL.insertar(persona2);
		arbolAVL.insertar(persona3);
		arbolAVL.insertar(persona4);
		arbolAVL.insertar(persona5);
		arbolAVL.insertar(persona6);
		arbolAVL.insertar(persona7);
		arbolAVL.insertar(persona8);
		arbolAVL.insertar(persona9);
		arbolAVL.insertar(persona10);
		System.out.println("Amplitud y Niveles:");
		arbolAVL.listarAmplitudNiveles();
		
		//Buscar Persona 10 en el arbolAVL
		System.out.println("\n---Método de Búsqueda de Personas---");
		tiempo = System.nanoTime();
		resul = arbolAVL.buscar(persona10);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda Persona 10: " + (resul?"Econtrado":"No encontrado") + " en " + tiempo + "ns");
		
		//Buscar persona no ingresada
		tiempo = System.nanoTime();
		resul = arbolAVL.buscar(auxpersona);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Búsqueda Persona No Ingresada: " + (resul?"Econtrado":"No encontrado") + " en " + tiempo + "ns");
		
		//Buscar persona 10 usando el método para buscar con cedula
		System.out.println("\n---Método Implementado de Búsqueda de Personas por Cédula---");
		tiempo = System.nanoTime();
		resul = buscar(arbolAVL.getRaiz(), "0714372661");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Búsqueda con la cedula Persona 10: " + (resul?"Econtrado":"No encontrado") + " en " + tiempo + "ns");
		
		//Buscar persona no ingresada usando el método para buscar con cedula
		tiempo = System.nanoTime();
		resul = buscar(arbolAVL.getRaiz(), "0706029188");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Búsqueda con la cédula Persona No Ingresada: " + (resul?"Econtrado":"No encontrado") + " en " + tiempo + "ns");
		
		System.out.println("\nNumero de Elementos del ArbolAVL: "+arbolAVL.numeroDeNodos());
		
		//Recorridos 
		System.out.println("\n------Recorridos arbolAVL------");
		System.out.println("PreOrder: ");
		arbolAVL.preOrder();
		System.out.println("\nInOrder: ");
		arbolAVL.inOrder();
		System.out.println("\nPostOrder: ");
		arbolAVL.postOrder();
		System.out.println("\nAmplitud y Niveles:");
		arbolAVL.listarAmplitudNiveles();
		
		//Eliminar el nodo Menor
		System.out.println("\nEliminando Dato Menor--> "+arbolAVL.menor());
		arbolAVL.eliminar(arbolAVL.menor());
		System.out.println("\nAmplitud y Niveles:");
		arbolAVL.listarAmplitudNiveles();
		
		//Altura del Árbol y Subárbol Izquierdo y Derecho
		System.out.println("\nAltura del arbol: " + arbolAVL.altura());
		System.out.println("Altura del Subárbol Izquierdo: " + alturaSubArbol(arbolAVL.getRaiz().getIz()));
		System.out.println("Altura del Subárbol Derecho: " + alturaSubArbol(arbolAVL.getRaiz().getDe()));
		
		//Eliminar el nodo Mayor
		System.out.println("\nEliminando Dato Mayor--> "+arbolAVL.mayor());
		arbolAVL.eliminar(arbolAVL.mayor());
		System.out.println("\nAmplitud y Niveles:");
		arbolAVL.listarAmplitudNiveles();
		
		//Altura del Árbol y Subárbol Izquierdo y Derecho
		System.out.println("\nAltura del arbol: " + arbolAVL.altura());
		System.out.println("Altura del Subárbol Izquierdo: " + alturaSubArbol(arbolAVL.getRaiz().getIz()));
		System.out.println("Altura del Subárbol Derecho: " + alturaSubArbol(arbolAVL.getRaiz().getDe()));
	}
	
	static boolean buscar(NodoArbol<Persona> arbol, String cedula) {
		boolean resul = false;
		if (arbol != null)
			if (arbol.getClave().getCedula().compareTo(cedula) == 0)
				resul = true;
			else {
				if (arbol.getClave().getCedula().compareTo(cedula) > 0) {
					resul = buscar(arbol.getIz(), cedula);
				} else {
					resul = buscar(arbol.getDe(), cedula);
				}
			}
		return resul;
	}

	static <T extends Comparable<T>> int alturaSubArbol(NodoArbol<T> arbol) {
		Arbol<T> aux = new Arbol<>();
		aux.setRaiz(arbol);
		return aux.altura();
	}

}
