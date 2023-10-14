package Evaluacion03;
import algoritmos.Algoritmos;
import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.NodoLista;
import tadLista.TadLista;

public class Principal {

	public static void main(String[] args) {
		Lista<Integer> lista = new TadLista<>();
		
		System.out.println("TadLista");
		for(int i=1; i<=10; ++i)
			AlgoritmosListas.insertarAlFinal(lista, Algoritmos.aleatorio(11, 50));
		lista.imprimirLista();
		invertir2(lista);
		System.out.println("TadLista invertida");
		lista.imprimirLista();	
		
	}
	
	public static <T> void invertir(Lista<T> lista) {
		T elem;
		if(!lista.esNulo()) {
			elem = lista.devolverClave();
			lista.asignarReferencia(lista.devolverSiguiente());
			invertir(lista);
			AlgoritmosListas.insertarAlFinal(lista, elem);
		}	
	}
	
	public static <T> void invertir2(Lista<T> lista) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		lista.asignarReferencia(invertir2R(aux));
		aux.asignarReferenciaSiguiente(null);
	}
	
	public static <T> NodoLista<T> invertir2R(Lista<T> listaaux) {
		NodoLista<T> aux = listaaux.devolverReferencia();
		NodoLista<T> elem;
		
		if(listaaux.devolverSiguiente()!=null) {
			listaaux.asignarReferencia(listaaux.devolverSiguiente());
			elem = invertir2R(listaaux);
			listaaux.asignarReferenciaSiguiente(aux);
			listaaux.asignarReferencia(listaaux.devolverSiguiente());
			
			
		}else {
			listaaux.asignarReferencia(aux);
			elem = aux;
		}
		
		return elem;
	}
}
