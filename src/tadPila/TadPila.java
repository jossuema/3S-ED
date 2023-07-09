package tadPila;

public class TadPila<T extends Comparable<T>> implements Pila<T>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodoPila<T> pila;
	private String nombre;
	
	public TadPila () {
		this("");
	}

	public TadPila(String nombre) {
		pila=null;
		this.nombre = nombre;
	}

    public boolean pilaVacia () {
      	return pila == null;
    }
        
    public void eliminarPila () {
      	pila = null;
    }

    public String getNombre() {
		return this.nombre;
	}
    
    public T cima () throws PilaVacia {
    	if (pilaVacia ())
       		throw new PilaVacia ("La pila est� vac�a");
       	return pila.dato;
    }
        
    public void apilar (T dato) {
        NodoPila<T> aux;
        aux = new NodoPila<>(dato, pila);
        pila = aux;
    }

    public T desapilar () throws PilaVacia {
        T resultado;
        if (pilaVacia ()) {  
             throw new PilaVacia ("Desapilar: La pila est� vac�a");
        }
        resultado = pila.dato;
        pila = pila.siguiente;
        return resultado;
    }

    public void decapitar () throws PilaVacia {
        if (pilaVacia ()) {  
             throw new PilaVacia ("Decapitar: La pila est� vac�a");
        }
        pila = pila.siguiente;
    }

    @Override
	public String toString() {
		return nombre + ": " + stringDePila();
	}
    
    public String stringDePila() {
    	NodoPila<T> aux = pila;
    	StringBuffer msj = new StringBuffer();
    	while(aux!= null) {
    		msj.append(aux.dato);
    		msj.append(" ");
    		aux = aux.siguiente;
    	}
    	return msj.toString();
    }

	public void imprimirPila () {
        NodoPila<T> aux;
        System.out.print ("Estado de la pila "+this.nombre+": ");
        aux = pila;
        while (aux != null) {
            System.out.print (aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println ();
    }
        
    public int numElemPila () {
        NodoPila<T> aux;	
        int resul;
        
        aux = pila;
        resul = 0;
        while (aux != null) {
         	++resul;
        	aux = aux.siguiente;
        }
        return resul;
    }
    
    /**
     * Hace la llamada al metodo recursivo menorDato que devuelve el nodo con el dato menor que luego es devuelto
     */
    public T menorDato() {
    	return menorDato(pila).dato;
    }
    
    
    /**
     * Recorre recursivamente cada nodo de la pila
     * Devuelve el nodo el cual su dato sea menor al comparado
     * La clase con la que se use el TAD debe implementar el metodo compareTo de la interfaz Comparable
     * @param aux
     * @return
     */
    private NodoPila<T> menorDato(NodoPila<T> aux) {
    	
    	if(aux.siguiente==null) {
    		return aux;
    	}
    	
    	NodoPila<T> nodos = menorDato(aux.siguiente);
    	
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
    	return mayorDato(pila).dato;
    }
    
    /**
     * Recorre recursivamente cada nodo de la pila
     * Devuelve el nodo el cual su dato sea mayor al comparado
     * La clase con la que se use el TAD debe implementar el metodo compareTo de la interfaz Comparable
     * @param aux
     * @return
     */
    private NodoPila<T> mayorDato(NodoPila<T> aux) {
    	
    	if(aux.siguiente==null) {
    		return aux;
    	}
    	
    	NodoPila<T> nodos = menorDato(aux.siguiente);
    	
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
    	return busqueda(dato, pila);
    }
    
    /**
     * Recive el dato y el nodo del dato que va a comparar.
     * Itera por cada nodo de la pila
     * El resultado del metodo dependera directamente de la implemetacion del metodo compareTo de la interfaz Comparable.
     * Si el metodo compareTo devuelve cero es decir, encontro una igualdad el metodo devolvera true o de lo contrario false.
     * @param dato
     * @param aux
     * @return
     */
    private boolean busqueda(T dato, NodoPila<T> aux) {
    	if(dato.compareTo(aux.dato) == 0){
    		return true;
    	}
    	
    	if(aux.siguiente == null) {
    		return false;
    	}
    	
    	return busqueda(dato, aux.siguiente);
    }

	@Override
	public T elementoFinal() {
		
		return elementoFinal(pila);
	}
	
	private T elementoFinal(NodoPila<T> aux) {
		if(aux.siguiente == null) {
			return aux.dato;
    	}
		
		return elementoFinal( aux.siguiente);
	}
}