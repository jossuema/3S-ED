package circularesOrdenadas;

import java.io.Serializable;

public class NodoLista<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public T clave;
	public NodoLista<T> sig;
	public NodoLista(T x) {
		clave=x;
		sig=null;
	}
}

