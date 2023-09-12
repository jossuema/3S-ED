package grafos;

import tadCola.*;

public class Recorridos {

	public static void recorrerProfundidad (Grafo g, int v, boolean[] visitados) {
		  //se marca el vértice v como visitado
		  visitados[v] = true;
		  //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
		  System.out.print(v + " ");
		  //se examinan los vértices adyacentes a v para continuar el recorrido
		  for (int i=0; i<g.obtenerNumVertices();i++){
			if ((v!=i) && (!visitados[i]) && (g.existeArista(v,i)) )
				recorrerProfundidad(g, i, visitados);					
		  }
	  }
	  
	   //procedimiento no recursivo
	   public static  void profundidad (Grafo g) {
		   boolean visitados[] = new boolean[g.obtenerNumVertices()];
		   //inicializo el vector: pongo todos los campos a false
		   for (int i=0;i<g.obtenerNumVertices();i++)
			   visitados[i]=false;
		   
		   //Se relanza el recorrido en cada vértice no visitado hasta que estén todos visitados
		   for (int i=0;i<g.obtenerNumVertices();i++){
			   if (!visitados[i])
				   recorrerProfundidad(g, i, visitados);
		   }
		   System.out.println();
	   }
	 /**
	  * 
	  *   	RECORRIDO EN AMPLITUD
	  *     @throws ColaVacia 
	  *   
	  */
	   
	   public static void amplitud (Grafo g){
		   //se requiere una cola/lista donde guardar
		   TadCola<Integer> cola = new TadCola<>();
		   boolean visitados[] = new boolean[g.obtenerNumVertices()];
		   int v; //vértice actual
		   
		   //Se inicializa el array visitados[] a false
		   for (int i=0;i<g.obtenerNumVertices();i++)
			   visitados[i]=false;
		   
		   //El recorrido en amplitud se inicia en cada vértice no visitado 
		   for (int i=0; i<g.obtenerNumVertices(); i++){
			   //se pone en la cola el vértide de partida y se marca como visitado
			if (!visitados[i]){
				cola.encolar(i);	
			    visitados[i]=true;
			   
				while (!cola.colaVacia()) {
					// desencolo, trato el vértice (en este caso, solo es mostrar pantalla)
					try {
						v = cola.desencolar();

						System.out.print(v + " ");
						// y encolo los nodos adyacentes a v.
						for (int j = 0; j < g.obtenerNumVertices(); j++) {
							if ((v != j) && ((g.existeArista(v, j)) && (!visitados[j]))) {
								cola.encolar(j);
								visitados[j] = true;
							}
						}
					} catch (ColaVacia e) {

					}
				}
			 }
	      }
		   System.out.println();
	   }
	   
} // fin de la clase


