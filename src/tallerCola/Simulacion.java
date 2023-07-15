package tallerCola;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Simulacion {
	public static void simulacion(int numeroSegundos, int paginasPorMinuto) throws ColaVacia {
		Impresora impresoraLaboratorio = new Impresora(paginasPorMinuto);     
		Cola<Integer> tiemposEspera = new TadCola<>();
		Cola<Tarea> colaImpresion =  new TadCola<>();
		Tarea tarea, tareaSiguiente;
		int esperaPromedio, n;

		for (int segundoActual = 0; segundoActual < numeroSegundos; segundoActual++) {
			if (nuevaTareaImpresion()) {
		     	tarea = new Tarea(segundoActual);
		  		colaImpresion.encolar(tarea);
		    }
			
			if (!impresoraLaboratorio.ocupada() && 
					!colaImpresion.colaVacia()) {
				tareaSiguiente = colaImpresion.desencolar();
				impresoraLaboratorio.iniciarNueva(tareaSiguiente);
				
				tiemposEspera.encolar( 
						tareaSiguiente.tiempoEspera(segundoActual));

			}
			      	 //ver procedimiento

			//El método tictac disminuye el temporizador interno y pone la 
			//impresora en disponible si la tarea se ha completado
			impresoraLaboratorio.tictac(); 
		} //fin del for
			        
		n = tiemposEspera.numElemCola();
		esperaPromedio = 0;
		
		for (int i = 0; i < n; i++) {
			int aux = tiemposEspera.desencolar();
			esperaPromedio += aux;
			
			
		}
		
		esperaPromedio = esperaPromedio / n;
		
		System.out.println("El tiempo de espera promedio de las tareas es de: "+esperaPromedio);
		System.out.println("Quedaron "+n+" tareas restantes");
			     //Calcular aquí el tiempo de espera promedio
			     //Codifique aquí para mostrar en consola la salida solicitada
	} //fin del método simulacion

	public static boolean nuevaTareaImpresion(){
		int numero = (int) (Math.random() * 180 + 1);
		return (numero == 180);
   }
			    
   public static void main(String[] args) {
     try {
		simulacion(3600, 5); //simular 3600 segundos a 5 páginas/min
	  } catch (ColaVacia e) {}	   }

}
