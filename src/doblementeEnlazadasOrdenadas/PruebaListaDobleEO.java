package doblementeEnlazadasOrdenadas;

import java.io.IOException;
import java.util.Scanner;

import Algoritmos.Algoritmos;
import archivos.Escritura;
import archivos.Lectura;
import doblementeEnlazadasOrdenadas.Lista;

public class PruebaListaDobleEO {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		doblementeEnlazadasOrdenadas.Lista<Integer> lista = new Lista<>("Lista DEO");
		doblementeEnlazadasOrdenadas.Lista<Integer> listalectura = new Lista<>("Lista DEO");
		
		String nombreArchivo = "ListaDobleEO.dat";
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
		System.out.println("Cantidad numeros primos de la lista "+ lista.getNombre() + " : "+lista.contar(lista));
		
		System.out.println("Guardando lista en el archivo..");
		
		try {
			salida.Abrir();
			salida.Escribir(lista);
			salida.Cerrar();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Borrando elementos de la lista..");
		lista.eliminarLista();
		lista.imprimirLista();
		
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
}
