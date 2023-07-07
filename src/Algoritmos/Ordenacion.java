package Algoritmos;

public class Ordenacion {
	private static <T extends Comparable<T>> void intercambiar(T[] vector, int a, int b) {
		T aux;
		
		aux = vector[a];
		vector[a] = vector[b];
		vector[b] = aux;
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] vector) {
		//primer lazo para las pasadas
		//segundo lazo para las comparaciones por pasada
		for(int i=0; i<=vector.length-1; ++i)
			for(int j=0; j<=vector.length-2; ++j)
				if(vector[j].compareTo(vector[j+1]) > 0) {
					intercambiar(vector, j, j+1);
				}
					
	}
	
	public static <T extends Comparable<T>> void bubbleSortR(T[] vector) {
		bubbleSortR(vector, 0);
	}
	
	public static <T extends Comparable<T>> void bubbleSortR(T[] vector, int i) {
		//primer lazo para las pasadas
		//segundo lazo para las comparaciones por pasada
		boolean ordenado = true;
		if(i<=vector.length-1) {
			for(int j=0; j<=vector.length-2; ++j)
				if(vector[j].compareTo(vector[j+1]) > 0) {
					intercambiar(vector, j, j+1);
					ordenado = false;
				}
			if(!ordenado)
				bubbleSortR(vector, i+1);
			
		}
	}
	
	public static <T extends Comparable<T>> void seleccion(T[] vector) {
		int indiceMenor, i, j, n;
		n = vector.length;
		for (i = 0; i < n - 1; i++) { // comienzo de la exploraci�n en �ndice i
			indiceMenor = i; // j explora la sublista a[i+1]..a[n-1]
			for (j = i + 1; j < n; j++)
				if (vector[j].compareTo(vector[indiceMenor]) < 0)
					indiceMenor = j; // sit�a el elemento mas peque�o en a[i]
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
		}
	}
	
	public static <T extends Comparable<T>> void insercion(T[] vector) {
		int i, j;
		T aux;
		for (i = 1; i < vector.length; i++) {
			/*
			 * �ndice j es para explorar la sublista a[i-1]..a[0] buscando la posici�n
			 * correcta del elemento destino
			 */
			j = i;
			aux = vector[i];
			// se localiza el punto de inserci�n explorando hacia abajo
			while (j > 0 && vector[j - 1].compareTo(aux) > 0) {
				// desplazar elementos hacia arriba para hacer espacio
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
		}
	}
	
	public static <T extends Comparable<T>> void quickSort(T a[])
	{
		quickSort(a, 0, a.length-1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T a[], int primero, int ultimo) {
		int i, j, central;
		T pivote;
		central = (primero + ultimo) / 2;
		pivote = a[central];
		i = primero;
		j = ultimo;
		do {
			while(a[i].compareTo(pivote)<0)
				i++;
			while (a[i].compareTo(pivote)>0)
				j--;
			if (i <= j) {
				intercambiar(a, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(a, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quickSort(a, i, ultimo); // mismo proceso con sublista drcha
	}
}
