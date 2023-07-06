package tadCola;

public class TadCola<T> implements Cola<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodoCola<T> principio;
	private NodoCola<T> fin;
	private String nombre;
	
	public String getNombre() {
		return this.nombre;
	}

	public TadCola(){
		this("");
	}
	
	public TadCola (String nombre) {
		principio = null;
		fin = null;
		this.nombre = nombre;
	}

	public boolean colaVacia () {
		return principio==null;	
	}
	public void eliminarCola () {
		principio = null;
		fin = null;
	}
	public T primero () throws ColaVacia {
    	if (colaVacia ())
    		throw new ColaVacia ("La cola est� vac�a");
    	return principio.dato;
	}
	public void encolar (T x) {
        NodoCola<T> aux;
        aux = new NodoCola<>(x,null);
        if (principio == null) {
        	principio = aux;
        	fin = aux;
        }
        else {
        	fin.siguiente = aux;
        	fin = aux;
        }
	}
	public T desencolar () throws ColaVacia {
        T resultado;
        if (colaVacia ()) {  
          throw new ColaVacia ("Desencolar: La cola est� vac�a");
        }
        resultado = principio.dato;
        principio = principio.siguiente;
        if (principio == null)
        	fin = null;
        return resultado;
		
	}
	
	public void quitarPrimero () throws ColaVacia {
	    if (colaVacia ()) {  
	    	throw new ColaVacia ("Quitar primero: La cola est� vac�a");
	    }
	    principio = principio.siguiente;
	    if (principio == null)
	    	fin = null;
	}
	
	public void mostrarEstadoCola () {
		System.out.println("Estado de la cola:");
		System.out.println("N�mero de elementos: "+this.numElemCola());
		if(!colaVacia()) {
	        System.out.println("Primer elemento - Clave: "+principio.dato);
	        System.out.println("�ltimo elemento - Clave: "+fin.dato);
		}
    }
	
	public void imprimirCola () {
        NodoCola<T> aux;
        System.out.print ("Estado de la cola: ");
        aux = principio;
        while (aux != null) {
          System.out.print (aux.dato + " ");
          aux = aux.siguiente;
        }
        System.out.println ();
      }
	
	public int numElemCola () {
        NodoCola<T> aux;	
        int resul;
        
          aux = principio;
          resul = 0;
          while (aux != null) {
        	++resul;
        	aux = aux.siguiente;
          }
          return resul;
        }
	
	public void invertirCola () throws ColaVacia {
		T elem;
		if (!colaVacia()) {
			elem = desencolar();	
			invertirCola();
			encolar(elem);
		}
	}
	
	@Override
	public String toString() {
		return nombre + ": " + stringDeCola();
	}
	
	public String stringDeCola() {
		StringBuffer msj = new StringBuffer();
		NodoCola<T> aux = principio;
		while(aux != null) {
			msj.append(aux.dato);
			msj.append(" ");
			aux = aux.siguiente;
		}
		return msj.toString();
	}
}
