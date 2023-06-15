package Clase4;

import java.io.Serializable;

public class Direccion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Direccion(String ciudad) {
		super();
		Ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Direccion [Ciudad=" + Ciudad + "]";
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String Ciudad;
}
