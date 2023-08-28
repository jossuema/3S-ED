package Taller04;

public class Persona implements Comparable<Persona>{
	public Persona(String nombre, String cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	private String nombre;
	private String cedula;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public int compareTo(Persona p) {
		return this.cedula.compareTo(p.getCedula());
	}
	
	public String toString() {
		return cedula + "-" + nombre + "; ";
	}
}
