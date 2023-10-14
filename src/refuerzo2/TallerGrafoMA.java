package refuerzo2;

import algoritmos.AlgoritmosGrafos;
import grafos.GrafoMA;

public class TallerGrafoMA {

	public static void main(String[] args) {
		GrafoMA grafo = new GrafoMA(15, true);// Dirigido -- true

		// Grafo Dirigido
		grafo.setNombre("Grafo 1");
		grafo.insertaVertice(15);
		grafo.insertaArista(0, 1);
		grafo.insertaArista(0, 2);
		grafo.insertaArista(1, 0);
		grafo.insertaArista(1, 3);
		grafo.insertaArista(1, 2);
		grafo.insertaArista(2, 1);
		grafo.insertaArista(2, 0);
		grafo.insertaArista(2, 5);
		grafo.insertaArista(2, 8);
		grafo.insertaArista(3, 1);
		grafo.insertaArista(3, 6);
		grafo.insertaArista(4, 0);
		grafo.insertaArista(4, 5);
		grafo.insertaArista(5, 4);
		grafo.insertaArista(5, 9);
		grafo.insertaArista(5, 2);
		grafo.insertaArista(6, 3);
		grafo.insertaArista(6, 7);
		grafo.insertaArista(7, 6);
		grafo.insertaArista(7, 10);
		grafo.insertaArista(7, 8);
		grafo.insertaArista(8, 2);
		grafo.insertaArista(8, 9);
		grafo.insertaArista(8, 7);
		grafo.insertaArista(8, 12);
		grafo.insertaArista(9, 5);
		grafo.insertaArista(9, 8);
		grafo.insertaArista(10, 7);
		grafo.insertaArista(10, 11);
		grafo.insertaArista(10, 14);
		grafo.insertaArista(11, 10);
		grafo.insertaArista(11, 12);
		grafo.insertaArista(12, 8);
		grafo.insertaArista(12, 11);
		grafo.insertaArista(13, 11);
		
		AlgoritmosGrafos.estadoGrafo(grafo);

		System.out.println("Matriz de Caminos del : " + grafo.getNombre());
		AlgoritmosGrafos.imprimirMatriz(AlgoritmosGrafos.matrizCaminos(grafo));
	}

}
