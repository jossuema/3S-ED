package Algoritmos;

import tadLista.Lista;
import tadLista.TadLista;

public class AlgoritmosListas {
	public static <T> boolean insertarPrincipio(Lista<T> lista, T dato) {
		boolean resul = false;
		if(lista!=null) {
			resul = true;
			lista.crearNodo();
			lista.asignarClave(dato);
		}
		
		return resul;
	}
	
	public static <T> boolean insertarFinal(Lista<T> lista, T dato) {
		if(lista.devolverReferencia()==null) {
			insertarPrincipio(lista, dato);
			return true;
		}
		
		T elem = lista.devolverClave();
		lista.asignarReferencia(lista.devolverSiguiente());
		boolean resul = insertarFinal(lista, dato);
		insertarPrincipio(lista, elem);
		
		
		return resul;
	}
	
	public static <T> boolean eliminarPrimero(Lista<T> lista) {
		boolean resul = false;
		
		if(lista!=null) {
			lista.asignarReferencia(lista.devolverSiguiente());
			resul = true;
		}
		
		return resul;
	}
	
	public static <T> boolean insertarAlFinal(Lista<T> lista, T dato) {
		if(!lista.esNulo()) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(lista.devolverReferencia());
			return insertarAlFinalR(aux, dato);
		}else {
			insertarPrincipio(lista, dato);
			return true;
		}
	}
	
	public static <T> boolean insertarAlFinalR(Lista<T> aux, T dato) {
		boolean resul = false;
		
		if(aux.devolverSiguiente()!=null) {
			aux.asignarReferencia(aux.devolverSiguiente());
			resul = insertarAlFinalR(aux, dato);
		}else {
			Lista<T> aux2 = new TadLista<>();
			insertarPrincipio(aux2, dato);
			aux.asignarReferenciaSiguiente(aux2.devolverReferencia());
			resul = true;
		}
		
		return resul;
	}
	
	public static <T> int contar(Lista<T> lista) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return contarR(aux);
 	}
	
	public static <T> int contarR(Lista<T> aux) {
		if(!aux.esNulo()) {
			aux.asignarReferencia(aux.devolverSiguiente());
			return 1 + contarR(aux);
		}else {
			return 0;
		}
	}
	
	public static <T> void duplicarLista1(Lista<T> listaO, Lista<T> listaD) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(listaO.devolverReferencia());
		duplicarLista1R(aux, listaD);
	}
	
	public static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD) {
		if(!aux.esNulo()) {
			insertarAlFinal(listaD, aux.devolverClave());
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista1R(aux, listaD);
		}
	}
	
	public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(listaO.devolverReferencia());
		duplicarLista2R(aux, listaD);
	}
	
	public static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD) {
		T elem;
		if(!aux.esNulo()) {
			elem = aux.devolverClave();
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista2R(aux, listaD);
			insertarPrincipio(listaD, elem);
		}
		
	}
	
	public static <T extends Comparable<T>> boolean buscar(Lista<T> lista, T dato) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return buscarR(aux, dato);
	}
	private static <T extends Comparable<T>> boolean buscarR(Lista<T> aux, T dato) {
		boolean resul = false;
		if(!aux.esNulo()) {
			if(aux.devolverClave().compareTo(dato) == 0){
				resul = true;
			}else {
				aux.asignarReferencia(aux.devolverSiguiente());
				resul = buscarR(aux,dato);
			}
		}
		
		return resul;
	}
}
