package PracticaClase01;

public class Persona {
	private String Cedula;
    private String Nombre;
    private int Edad;
    
    public Persona(String cedula, String nombre, int edad) {
    	this.Cedula = cedula;
    	this.Nombre = nombre;
    	this.Edad = edad;
    }
    
    public Persona(String cedula, String nombre) {
    	this(cedula, nombre, 0);
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

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	@Override
	public String toString() {
		return Cedula + " - " + Nombre + " - " + Edad;
	}
    
	
}
