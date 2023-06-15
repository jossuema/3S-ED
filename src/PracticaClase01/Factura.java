package PracticaClase01;


public class Factura {
	private int Numero;
	private Cliente Cliente;
	
	public Factura(int numero, Cliente cli) {
		super();
		this.Numero = numero;
		this.Cliente = cli;
		
	}

	@Override
	public String toString() {
		return "Factura [Numero=" + Numero + ", Cliente=" + Cliente + "]";
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public Cliente getFecha() {
		return Cliente;
	}

	public void setFecha(Cliente cli) {
		this.Cliente = cli;
	}
	
	
}
