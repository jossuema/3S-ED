package tadLista;

public class NodoLista<T> {
	T clave;
	NodoLista<T> sig;
	NodoLista (T x, NodoLista<T> n) {
		clave = x;
		sig = n;
	}
}

