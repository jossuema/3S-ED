package Taller04;

import arbolBinario.Arbol;
import arbolBinario.ArbolBB;
import arbolBinario.NodoArbol;

public class TestArbolBB {
public static void main(String[] args) {
		boolean encontrado;
		
		Persona personJ = new Persona("0706209905", "Malla Josue");
		
		Persona persona10 = new Persona("0714372661", "Alan Coronado");
		Persona persona9 = new Persona("0721687531", "John Bocca");
		Persona persona8 = new Persona("0733723480", "Bill Gallardo");
		Persona persona7 = new Persona("0753927813", "Ada Lomas");
		Persona persona6 = new Persona("0705297810", "Brian Banegas");
		Persona persona5 = new Persona("0718834146", "Dennis Rivera");
		Persona persona4 = new Persona("0745348854", "Adi Shumi");
		Persona persona2 = new Persona("0724593975", "Alan Tumbaco");
		Persona persona3 = new Persona("0700903750", "Richard Briones");
		Persona persona1 = new Persona("0705355188", "Linus Torres");
		
		Arbol<Persona> arbolP10 = new Arbol<Persona>(persona10);
		Arbol<Persona> arbolP9 = new Arbol<Persona>(persona9);
		Arbol<Persona> arbolP5 = new Arbol<Persona>();
		
		Arbol<Persona> arbolP8 = new Arbol<Persona>(persona8);
		Arbol<Persona> arbolP7 = new Arbol<Persona>(persona7);
		Arbol<Persona> arbolP4 = new Arbol<Persona>();
		
		Arbol<Persona> arbolP2 = new Arbol<Persona>();
		
		Arbol<Persona> arbolP6 = new Arbol<Persona>(persona6);
		Arbol<Persona> arbolP3 = new Arbol<Persona>();
		
		Arbol<Persona> arbolB = new Arbol<Persona>();
		
		Arbol.juntar(arbolP5, persona5, arbolP10, arbolP9);
		Arbol.juntar(arbolP4, persona4, arbolP8, arbolP7);
		Arbol.juntar(arbolP2, persona2, arbolP5, arbolP4);
		Arbol.juntar(arbolP3, persona3, null, arbolP6);
		Arbol.juntar(arbolB, persona1, arbolP3, arbolP2);
		
		arbolB.setNombre("Arbol Binario");
		
		//Arbol Binario de Busqueda
		ArbolBB<Persona> arbolBB = new ArbolBB<Persona>("ArbolBB");
		
		/**arbolBB.insertar(arbolB.getRaiz().getClave());
		arbolBB.insertar(arbolP2.getRaiz().getClave());
		arbolBB.insertar(arbolP3.getRaiz().getClave());
		arbolBB.insertar(arbolP6.getRaiz().getClave());
		arbolBB.insertar(arbolP4.getRaiz().getClave());
		arbolBB.insertar(arbolP5.getRaiz().getClave());
		arbolBB.insertar(arbolP7.getRaiz().getClave());
		arbolBB.insertar(arbolP8.getRaiz().getClave());
		arbolBB.insertar(arbolP9.getRaiz().getClave());
		arbolBB.insertar(arbolP10.getRaiz().getClave());
		**/
		
		arbolBB.insertar(persona1);
		arbolBB.insertar(persona2);
		arbolBB.insertar(persona3);
		arbolBB.insertar(persona6);
		arbolBB.insertar(persona4);
		arbolBB.insertar(persona5);
		arbolBB.insertar(persona7);
		arbolBB.insertar(persona8);
		arbolBB.insertar(persona9);
		arbolBB.insertar(persona10);
		
		//Recorridos Arbol Binario
		System.out.println("----------Arbol Binario----------");
		
		System.out.println("\nRecorrido en PreOrder");
		arbolP7.preOrder();
		System.out.println("\nRecorrido en InOrder");
		arbolP7.inOrder();
		System.out.println("\nRecorrido en PostOrder");
		arbolP7.postOrder();
		System.out.println("\nRecorrido en Amplitud");
		arbolP7.listarAmplitud();
		System.out.println("\nRecorrido en Amplitud y Niveles");
		arbolP7.listarAmplitudNiveles();
		
		//Recorridos Arbol Binario de Busqueda
		System.out.println("\n----------Arbol Binario de Busqueda----------");
		
		System.out.println("\nRecorrido en PreOrder");
		arbolBB.preOrder();
		System.out.println("\nRecorrido en InOrder");
		arbolBB.inOrder();
		System.out.println("\nRecorrido en PostOrder");
		arbolBB.postOrder();
		System.out.println("\nRecorrido en Amplitud");
		arbolBB.listarAmplitud();
		System.out.println("\nRecorrido en Amplitud y Niveles");
		arbolBB.listarAmplitudNiveles();
		
		long tiempo;
		
		System.out.println("\n------------------------------");
		
		//Busquedas persona #10 en el Arbol Binario
		tiempo = System.nanoTime();
		encontrado = arbolB.buscar(persona10);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("\nBusqueda de persona 10: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		//Busquedas persona #10 en el Arbol Binario de Busqueda
		tiempo = System.nanoTime();
		encontrado = arbolBB.buscar(persona10);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona 10: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		//Busquedas persona no ingresada en el Arbol Binario
		tiempo = System.nanoTime();
		encontrado = arbolB.buscar(personJ);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("\nBusqueda de persona nueva: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
				
		//Busquedas persona no ingresada el Arbol Binario de Busqueda
		tiempo = System.nanoTime();
		encontrado = arbolBB.buscar(personJ);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona nueva: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		
		tiempo = System.nanoTime();
		encontrado = buscarAB(arbolB.getRaiz(), "0714372661");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona 10 por cedula: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		tiempo = System.nanoTime();
		encontrado = buscarAB(arbolB.getRaiz(), "0706209905");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona nueva por cedula: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		tiempo = System.nanoTime();
		encontrado = buscarABB(arbolBB.getRaiz(), "0714372661");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona 10 por cedula: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		tiempo = System.nanoTime();
		encontrado = buscarABB(arbolBB.getRaiz(), "0706209905");
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Busqueda de persona nueva por cedula: " + (encontrado?"Encontrado":"No Encontrado") + " en " + tiempo + "ns");
		
		//Nodos y Altura Arbol Binario
		System.out.println("\nNumero de nodos y altura del Arbol Binario:" + "\nNodos>>"+ arbolP7.numeroDeNodos() + ", altura>>" + arbolP7.altura());
		System.out.println("Altura SubArbol Izquierdo: " + alturaSubArbol(arbolB.getRaiz().getIz()) + ", Altura SubArbol Derecho: " + alturaSubArbol(arbolB.getRaiz().getDe()));
		
		//Nodos y Altura Arbol Binario de Busqueda
		System.out.println("\nNumero de nodos y altura del Arbol Binario de Busqueda:" + "nodos>>"+ arbolBB.numeroDeNodos() + ", altura>>" + arbolBB.altura());
		System.out.println("Altura SubArbol Izquierdo: " + alturaSubArbol(arbolBB.getRaiz().getIz()) + ", Altura SubArbol Derecho: " + alturaSubArbol(arbolBB.getRaiz().getDe()));
		
		//Menor y Mayor dato de un Arbol Binario
		System.out.println("\nArbol Binario: " + "Menor dato>>" + arbolB.menor() + ", Mayor dato>>" + arbolB.mayor());
		
		//Menor y Mayor dato de un Arbol Binario de Busqueda
		System.out.println("Arbol Binario de Busqueda: " + "Menor dato>>" + arbolBB.menor() + ", Mayor dato>>" + arbolBB.mayor());
	
		//Eliminar Raiz Arbol Binario
		System.out.println("\nEliminar raiz del Arbol Binario");
		arbolP7.eliminar(arbolB.getRaiz().getClave());
		
		arbolP7.listarAmplitudNiveles();
		
		//Eliminar Raiz Arbol Binario de Busqueda
		System.out.println("\nEliminar raiz del Arbol Binario de Busqueda");
		arbolBB.eliminar(arbolBB.getRaiz().getClave());
		
		arbolBB.listarAmplitudNiveles();
	}
	
	/**
	 * Metodo de busqueda de dato a partir de cedula para un arbol Binario
	 * @param arbol
	 * @param cedula
	 * @return
	 */
	static boolean buscarAB(NodoArbol<Persona> arbol, String cedula) {
		boolean resul = false;	
		if(arbol != null)
			if(arbol.getClave().getCedula().compareTo(cedula) ==0)
				resul = true;
			else {
				resul = buscarAB(arbol.getIz(), cedula);
				if(!resul)
					resul = buscarAB(arbol.getDe(), cedula);
			}
		return resul;
	}
	
	/**
	 * Metodo de busqueda de dato a partir de cedula para un arbol Binario de Busqueda
	 * @param arbol
	 * @param cedula
	 * @return
	 */
	static boolean buscarABB(NodoArbol<Persona> arbol, String cedula) {
		boolean resul = false;	
		if(arbol != null)
			if(arbol.getClave().getCedula().compareTo(cedula) == 0)
				resul = true;
			else {
				if(arbol.getClave().getCedula().compareTo(cedula) > 0) {
					resul = buscarABB(arbol.getIz(), cedula);
				}
				else {
					resul = buscarABB(arbol.getDe(), cedula);
				}
			}
		return resul;
	}
	
	//Metodo Altura SubArbol
	static <T extends Comparable<T>> int alturaSubArbol(NodoArbol<T> arbol) {
		Arbol<T> aux = new Arbol<>();
		aux.setRaiz(arbol);
		return aux.altura();
	}
}
