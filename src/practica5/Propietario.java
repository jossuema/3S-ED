package practica5;

import java.io.Serializable;

public class Propietario implements Serializable{
	
	public Propietario(String cedula, String nombre) {
		super();
		Cedula = cedula;
		Nombre = nombre;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Propietario() {}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Propietario [Cedula=" + Cedula + ", Nombre=" + Nombre + "]";
	}
	private String Cedula;
	private String Nombre;
}
