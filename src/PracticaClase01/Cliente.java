package PracticaClase01;

public class Cliente extends Persona{
	private int Codigo;
	
	public Cliente(String cedula, String nombre) {
		super(cedula, nombre);
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String cedula, String nombre, int edad) {
		super(cedula, nombre, edad);
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String cedula, String nombre, int edad, int codigo) {
		super(cedula, nombre, edad);
		this.Codigo = codigo;
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public String toString() {
		return "Cliente [Codigo=" + Codigo + "]";
	}*/

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
}
