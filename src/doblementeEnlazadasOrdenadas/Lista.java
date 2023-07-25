package doblementeEnlazadasOrdenadas;

import java.io.Serializable;


public class Lista<T extends Comparable<T>> implements Serializable {
	private static final long serialVersionUID = 1L;
	private NodoLista<T> inicio;
	private String nombre;

	public Lista(String nombreLista) {
		inicio = null;
		nombre = nombreLista;
	}

	public NodoLista<T> getInicio() {
		return inicio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean busqueda(NodoLista<T> nodoLista, T x) {
		boolean resul = false;
		if (nodoLista != null)
			if (nodoLista.clave.compareTo(x) == 0)
				resul = true;
			else if (nodoLista.clave.compareTo(x) < 0)
				resul = busqueda(nodoLista.sig, x);
		return resul;
	}

	public boolean busqueda(T x) {
		return busqueda(inicio, x);
	}

	public void insertar(T clave) {
		NodoLista<T> anterior;
		NodoLista<T> actual;
		NodoLista<T> nuevo;
		boolean encontrado = false;

		anterior = inicio;
		actual = inicio;
		while ((actual != null) && !encontrado)
			if (actual.clave.compareTo(clave) < 0) {
				anterior = actual;
				actual = actual.sig;
			} else
				encontrado = true;
		if (actual == null) {
			nuevo = new NodoLista<T>(clave);
			if (inicio == null)
				inicio = nuevo;
			else {
				nuevo.ant = anterior;
				anterior.sig = nuevo;
			}
		} else if (actual.clave.compareTo(clave) > 0) {
			nuevo = new NodoLista<T>(clave);
			nuevo.sig = actual;
			nuevo.ant = actual.ant;
			actual.ant = nuevo;
			if (inicio != actual)
				anterior.sig = nuevo;
			else
				inicio = nuevo;
		} else
			System.out.println("error, la clave ya existe");
	}

	public void eliminar(T clave) {
		NodoLista<T> anterior, actual;
		boolean encontrado = false;

		anterior = inicio;
		actual = inicio;
		while ((actual != null) && !encontrado)
			if (actual.clave.compareTo(clave) < 0) {
				anterior = actual;
				actual = actual.sig;
			} else
				encontrado = true;
		if (actual == null)
			System.out.println("Error, el elemento no existe");
		else if (actual.clave.compareTo(clave) > 0)
			System.out.println("Error, el elemento no existe");
		else if (inicio == actual) {
			inicio = inicio.sig;
			inicio.ant = null;
		} else {
			anterior.sig = actual.sig;
			if(actual.sig != null)
				actual.sig.ant = anterior;
		}
	}

	public void imprimirLista() {
		NodoLista<T> aux;

		aux = inicio;
		System.out.print(nombre + ": ");
		while (aux != null) {
			System.out.print(aux.clave.toString() + " ");
			aux = aux.sig;
		}
		System.out.println("FIN");
	}
	
		
	
	public static <T extends Comparable<T>> int contar(Lista<T> lista) {
		Lista<T> aux = new Lista<T>("aux");
		aux.inicio = lista.inicio;
		return contar(aux, 0);
	}
	
	private static <T extends Comparable<T>> int contar(Lista<T> lista, int cont) {
		int clave;
		if(lista.inicio != null) {
			clave = (int) lista.inicio.clave;
			lista.inicio = lista.inicio.sig;
			if(esPrimo(clave)) {
				cont++;
			}
			cont = contar(lista, cont);
		}
		return cont;
	}
	
	private static boolean esPrimo(int clave) {
		boolean resul=false;
		int suma=0;
		for(int i=1; i<=clave;i++) {
			if((clave%i) == 0) {
				suma++;
			}
		}
		if(suma<=2) {
			resul=true;
		}else {
			resul=false;
		}
		return resul;
	}
	
	public void eliminarLista() {
		inicio = null;
	}
	
	
	
	@Override
	public String toString() {
		return nombre + ": " + stringDeLista();
	}
	
	private String stringDeLista() {
		StringBuffer cadena = new StringBuffer();
		NodoLista<T> aux;

		aux = inicio;
		while (aux != null) {
			cadena.append(aux.clave.toString());
			cadena.append(" ");
			aux = aux.sig;
		}
		cadena.append("FIN");
		return cadena.toString();
	}
	
	
}
