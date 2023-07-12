package hemisemestre;

import Algoritmos.Algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class Principal {
	public static void main(String[] args) throws ColaVacia {
		Pila<Persona> pilaAtendidos = new TadPila<>("atendidos");
		Cola<Persona> colaTerceraEdad = new TadCola<>("tercera edad");
		Cola<Persona> colaNormal = new TadCola<>("normal");
		int contadorTEA = 0, usoColaTE = 0;
		
		Persona persona;
		int i;
		for (i = 0; i < 100; i++) {
			persona = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 90));
			if(persona.getEdad() > 65) {
				if(colaTerceraEdad.colaVacia()) {
					usoColaTE++;
				}
				colaTerceraEdad.encolar(persona);
				
			}else {
				colaNormal.encolar(persona);
			}
			
			if(i>=10 && i%2==0) {
				if(!colaTerceraEdad.colaVacia()) {
					persona = colaTerceraEdad.desencolar();
					contadorTEA++;
				}else {
					persona = colaNormal.desencolar();
				}
				pilaAtendidos.apilar(persona);
			}
		}
		
		System.out.println("Ingresaron "+i+ " personas");
		System.out.println("Se atendieron "+ pilaAtendidos.numElemPila() + " personas");
		System.out.println(contadorTEA+" personas de la tercera edad y "+ (pilaAtendidos.numElemPila() - contadorTEA) +" personas más");
		System.out.println("La col tercera edad se uso "+ usoColaTE +" veces");
		
		System.out.println("---------------------------- Informe de la pila --------------------------");
		pilaAtendidos.imprimirPila();
		System.out.println((colaTerceraEdad.numElemCola() > 0)?"Quedan por atender a " + colaTerceraEdad.numElemCola() + " personas de la tercera edad": "No hay personas de la tercera edad por atender");
		if(colaTerceraEdad.numElemCola() > 0)
		colaTerceraEdad.imprimirCola();
		System.out.println("Y quedan por atender a "+ colaNormal.numElemCola()+" personas mas");
		colaNormal.imprimirCola();
		
		
	}
	
	public static int numTerceraEdad(Pila<Persona> pila) throws PilaVacia {
		int result = 0;
		Persona elem;
		
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			if(elem.getEdad() > 65) {
				result++;
			}
			result =+ numTerceraEdad(pila);
			pila.apilar(elem);
		}
		
		return result;
	}
}
