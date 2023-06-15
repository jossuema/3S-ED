package Clase4;

import java.io.Serializable;

public class Contacto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nombre;
	private Direccion Direccion;
	private int Edad;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Direccion getDireccion() {
		return Direccion;
	}
	public Contacto(String nombre, Clase4.Direccion direccion, int edad) {
		super();
		Nombre = nombre;
		Direccion = direccion;
		Edad = edad;
	}
	@Override
	public String toString() {
		return "Contacto [Nombre=" + Nombre + ", Direccion=" + Direccion + ", Edad=" + Edad + "]";
	}
	public void setDireccion(Direccion direccion) {
		Direccion = direccion;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	
	

}
