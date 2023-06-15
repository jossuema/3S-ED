package Clase4;

import java.io.IOException;
import archivos.Lectura;
import archivos.Escritura;

public class Principal {

	public static void main(String[] args) {
		String nombreArchivo = "MisContactos.dat";
		Escritura<Contacto> salida = new Escritura<>(nombreArchivo);
		Lectura<Contacto> entrada = new Lectura<>(nombreArchivo);
		
		Contacto contacto1 = new Contacto("Josue",new Direccion("Huaquillas"), 18);
		Contacto contacto4 = new Contacto("Poni",new Direccion("Pasaje"), 18);
		Contacto contacto2 = new Contacto("Pol",new Direccion("Machala"), 18);
		Contacto contacto3 = new Contacto("Fernan",new Direccion("Pasaje"), 18);
		
		System.out.println("Lista antes de guardar");
		System.out.println(contacto1);
		System.out.println(contacto2);
		System.out.println(contacto3);
		System.out.println(contacto4);
		
		System.out.println("----------------Guardando datos---------------");
		try {
			salida.Abrir();
			salida.Escribir(contacto1);
			salida.Escribir(contacto2);
			salida.Escribir(contacto3);
			salida.Escribir(contacto4);
			salida.Cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------Borrando contactos----------------");
		contacto1 = contacto2 = contacto3 = contacto4 = null;
		System.out.println(contacto1);
		System.out.println(contacto2);
		System.out.println(contacto3);
		System.out.println(contacto4);
		
		System.out.println("------------------Leyendo contactos----------------");
		try {
			entrada.Abrir();
			
			do {
				contacto1 = entrada.Leer();
				if(contacto1!=null)System.out.println(contacto1);
			}while(contacto1!=null);
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			try {
				entrada.Cerrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
