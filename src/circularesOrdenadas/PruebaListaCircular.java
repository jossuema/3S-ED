package circularesOrdenadas;

import java.io.IOException;
import java.util.Scanner;
import Algoritmos.Algoritmos;
import archivos.Escritura;
import archivos.Lectura;

public class PruebaListaCircular {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		circularesOrdenadas.Lista<Integer> lista = new Lista<>("Lista Circular");		
		circularesOrdenadas.Lista<Integer> listalectura = new Lista<>("Lista Circular");
		String nombreArchivo = "ListaCircular.dat";
		int n=10, dato;
		
		Escritura<Lista<Integer>> salida = new Escritura<>(nombreArchivo);
		Lectura<Lista<Integer>> entrada = new Lectura<>(nombreArchivo);
		
		for(int i=1; i<=n; i++) {
			lista.insertar(Algoritmos.aleatorio(10, 99));
		}
		
		lista.imprimirLista();
		System.out.print("Ingrese el dato a buscar:");
		dato = scan.nextInt();
		System.out.println("Búsqueda del dato "+dato+" : " +(lista.busqueda(dato)?"Encontrado":"No encontrado"));
		System.out.print("Ingrese el dato a eliminar:");
		dato = scan.nextInt();
		lista.eliminar(dato);
		lista.imprimirLista();
		System.out.println("Cantidad numeros de la lista "+ lista.getNombre() + " : "+contar(lista));
		
		System.out.println("Guardando lista en el archivo..");
		
		try {
			salida.Abrir();
			salida.Escribir(lista);
			salida.Cerrar();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Borrando elementos de la lista..");
		lista = null;
		System.out.println(lista);
		
		System.out.println("Leyendo datos de la lista en el archivo..");
		try {
			entrada.Abrir();
			listalectura = entrada.Leer();
			entrada.Cerrar();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		listalectura.imprimirLista();
	}
	
	public static <T extends Comparable<T>> int contar(Lista<T> lista) {
		if (lista.getUltimo() == null)
			return 0;
		else {
			return contar(lista, lista.getUltimo().sig, 0);
		}
	}

	private static <T extends Comparable<T>> int contar(Lista<T> aux, NodoLista<T> ultimo, int cont) {
		if (!aux.getUltimo().equals(ultimo)) {
			ultimo = ultimo.sig;
			cont = 1 + contar(aux, ultimo, cont);
		} else
			cont = cont + 1; // para contar el último
		return cont;
	}
}
