package CPE10;

import java.io.IOException;

import algoritmos.AlgoritmosGrafos;
import grafos.GrafoLA;
import tad.TADTeclado;

public class TallerGrafoLA {

	public static void main(String[] args) {
		GrafoLA grafo1 = new GrafoLA(8, false);// NO dirigido -- false
		GrafoLA grafo2 = new GrafoLA(5, true);// Dirigido -- True
		TADTeclado teclado = new TADTeclado();
		int vertice1, vertice2;
		boolean hayerror;
		// Grafo 1 - No Dirigido
		grafo1.setNombre("Grafo 1");
		grafo1.insertaVertice(8);
		grafo1.insertaArista(0, 2);
		grafo1.insertaArista(0, 3);
		grafo1.insertaArista(0, 4);
		grafo1.insertaArista(1, 2);
		grafo1.insertaArista(1, 3);
		grafo1.insertaArista(1, 5);
		grafo1.insertaArista(1, 6);
		grafo1.insertaArista(2, 6);
		grafo1.insertaArista(3, 5);
		grafo1.insertaArista(3, 7);
		grafo1.insertaArista(4, 6);
		AlgoritmosGrafos.estadoGrafo(grafo1);
		System.out.println("---Verificar aristas entre dos vertices Para eliminar una Arista---");
		do {
			hayerror = false;
			try {
				vertice1 = teclado.leerInt("Ingrese Vertice 1");
				vertice2 = teclado.leerInt("Ingrese Vertice 2");
				System.out.println("Existe arista entre " + vertice1 + " y " + vertice2 + "?");
				if (grafo1.existeArista(vertice1, vertice2)) {
					System.out.println("SI EXISTE. Eliminando Arista..");
					grafo1.eliminaArista(vertice1, vertice2);
					AlgoritmosGrafos.estadoGrafo(grafo1);
				} else {
					System.out.println("NO EXISTE. Ingrese nuevos Vertices");
					hayerror = true;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("Por favor, ingrese solo números enteros");
				hayerror = true;
			}
		}while(hayerror);
		
		// Grafo 2 - Dirigido
		grafo2.insertaVertice(5);
		grafo2.insertaArista(0, 1);
		grafo2.insertaArista(0, 3);
		grafo2.insertaArista(1, 2);
		grafo2.insertaArista(1, 4);
		grafo2.insertaArista(3, 1);
		grafo2.insertaArista(3, 3);
		grafo2.insertaArista(4, 1);
		grafo2.insertaArista(4, 2);
		grafo2.setNombre("Grafo 2");
		AlgoritmosGrafos.estadoGrafo(grafo2);
		System.out.println("---Verificar aristas entre dos vertices Para eliminar una Arista---");
		do {
			hayerror = false;
			try {
				vertice1 = teclado.leerInt("Ingrese Vertice 1");
				vertice2 = teclado.leerInt("Ingrese Vertice 2");
				System.out.println("Existe arista entre " + vertice1 + " y " + vertice2 + "?");
				if (grafo2.existeArista(vertice1, vertice2)) {
					System.out.println("SI EXISTE. Eliminando Arista..");
					grafo2.eliminaArista(vertice1, vertice2);
					AlgoritmosGrafos.estadoGrafo(grafo1);
				} else {
					System.out.println("NO EXISTE. Ingrese nuevos Vertices");
					hayerror = true;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("Por favor, ingrese solo números enteros");
				hayerror = true;
			}
		}while(hayerror);
		// Matriz de caminos del Grafo 2
		System.out.println("Matriz de Caminos del : " + grafo2.getNombre());
		AlgoritmosGrafos.imprimirMatriz(AlgoritmosGrafos.matrizCaminos(grafo2));
	}

}
