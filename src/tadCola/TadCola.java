package tadCola;

public class TadCola<T extends Comparable<T>> implements Cola<T> {
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
	
	/**
     * Hace la llamada al metodo recursivo menorDato que devuelve el nodo con el dato menor que luego es devuelto
     */
    public T menorDato() {
    	return menorDato(principio).dato;
    }
    
    
    /**
     * Recorre recursivamente cada nodo de la cola desde el nodo principio
     * Devuelve el nodo el cual su dato sea menor al comparado
     * La clase con la que se use el TAD debe implementar el metodo compareTo de la interfaz Comparable
     * @param aux
     * @return
     */
    private NodoCola<T> menorDato(NodoCola<T> aux) {
    	
    	if(aux.siguiente==null) {
    		return aux;
    	}
    	
    	NodoCola<T> nodos = menorDato(aux.siguiente);
    	
    	if(nodos.dato.compareTo(aux.dato) < 0) {
    		return nodos;
    	}else {
    		return aux;
    	}
    }
    
    /**
     * Hace la llamada al metodo recursivo mayorDato que devuelve el nodo con el dato mayor que luego es devuelto
     */
    public T mayorDato() {
    	return mayorDato(principio).dato;
    }
    
    /**
     * Recorre recursivamente cada nodo de la cola desde el nodo principio
     * Devuelve el nodo el cual su dato sea mayor al comparado
     * La clase con la que se use el TAD debe implementar el metodo compareTo de la interfaz Comparable
     * @param aux
     * @return
     */
    private NodoCola<T> mayorDato(NodoCola<T> aux) {
    	
    	if(aux.siguiente==null) {
    		return aux;
    	}
    	
    	NodoCola<T> nodos = menorDato(aux.siguiente);
    	
    	if(nodos.dato.compareTo(aux.dato) > 0) {
    		return nodos;
    	}else {
    		return aux;
    	}
    }
    
    /**
     * Hace la llamda al metodo recursivo busqueda
     * Devuelve true si el elemento tiene los mismos atributos que un elemento dentro de la cola
     */
    public boolean busqueda(T dato) {
    	return busqueda(dato, principio);
    }
    
    /**
     * Recive el dato y el nodo del dato que va a comparar.
     * Itera por cada nodo de la cola
     * El resultado del metodo dependera directamente de la implemetacion del metodo compareTo de la interfaz Comparable.
     * Si el metodo compareTo devuelve cero es decir, encontro una igualdad el metodo devolvera true o de lo contrario false.
     * @param dato
     * @param aux
     * @return
     */
    private boolean busqueda(T dato, NodoCola<T> aux) {
    	
    	if(dato.compareTo(aux.dato) == 0){
    		return true;
    	}
    	
    	if(aux.siguiente == null) {
    		return false;
    	}
    	
    	return busqueda(dato, aux.siguiente);
    }
    
    /**
     * El metodo devuelve directamente el dato final con la ayuda del nodoFinal sin la necesidad de implementar recursividad
     */
	public T elementoFinal() {
		return fin.dato;
	}
}
