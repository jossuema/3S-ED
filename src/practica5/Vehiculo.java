package practica5;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String uIN) {
		VIN = uIN;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public int getNumerosPasajeros() {
		return NumerosPasajeros;
	}
	public void setNumerosPasajeros(int numerosPasajeros) {
		NumerosPasajeros = numerosPasajeros;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public int getAnio() {
		return Anio;
	}
	public void setAnio(int anio) {
		Anio = anio;
	}
	public Propietario getDueno() {
		return Dueno;
	}
	public void setDueno(Propietario dueno) {
		Dueno = dueno;
	}
	public Vehiculo(String uIN, String marca, String modelo, int numerosPasajeros, double valor, int anio,
			Propietario dueno) {
		super();
		VIN = uIN;
		Marca = marca;
		Modelo = modelo;
		NumerosPasajeros = numerosPasajeros;
		Valor = valor;
		Anio = anio;
		Dueno = dueno;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [VIN=" + VIN + ", Marca=" + Marca + ", Modelo=" + Modelo + ", NumerosPasajeros="
				+ NumerosPasajeros + ", Valor=" + Valor + ", Año=" + Anio + ", Dueño=" + Dueno + "]";
	}
	public Vehiculo() {}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String VIN;
	private String Marca;
	private String Modelo;
	private int NumerosPasajeros;
	private double Valor;
	private int Anio;
	private Propietario Dueno;
	
}
