package tallerPila;

import tadPila.PilaVacia;
import tadPila.TadPila;

public class ExpresionPosFija {
    public static int evaluarExpresionPosfija(String expresion) {
        TadPila<Integer> pila = new TadPila<>();

        for (String elemento : expresion.split(" ")) {
            if (elemento.matches("\\d+")) {
                pila.apilar(Integer.parseInt(elemento));
            } else if (elemento.matches("[+\\-*/]")) {
                if (pila.pilaVacia()) {
                    System.out.println("Expresión mal ingresada");
                    return -1;
                }
                int opd2;
                try {
                    opd2 = pila.desapilar();
                } catch (PilaVacia e) {
                    System.out.println("Expresión mal ingresada");
                    return -1;
                }
                if (pila.pilaVacia()) {
                    System.out.println("Expresión mal ingresada");
                    return -1;
                }
                int opd1;
                try {
                    opd1 = pila.desapilar();
                } catch (PilaVacia e) {
                    System.out.println("Expresión mal ingresada");
                    return -1;
                }
                
                pila.apilar(operacion(elemento, opd1, opd2));
            }
        }

        if (pila.numElemPila() != 1) {
            System.out.println("Expresión mal ingresada");
            return -1;
        }

        try {
            return pila.desapilar();
        } catch (PilaVacia e) {
            System.out.println("Expresión mal ingresada");
            return -1;
        }
    }
    
    public static int operacion(String elemento, int opd1, int opd2) {
    	switch (elemento) {
	        case "+":
	            return (opd1 + opd2);
	        case "-":
	            return (opd1 - opd2);
	        case "*":
	            return (opd1 * opd2);
	        case "/":
	            return (opd1 / opd2);
	    }
    	return 0;
    }

    public static void main(String[] args) {
        String expresion = "10 4 2 * 5 - / 3 +";
        int resultado = evaluarExpresionPosfija(expresion);
        System.out.println("Resultado: " + resultado);
    }
}
