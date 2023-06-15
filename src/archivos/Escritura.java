package archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritura <T>{
	private String nombreArchivo;
	private FileOutputStream archivo;
	private ObjectOutputStream escritura;
	
	public Escritura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	public void Abrir() throws IOException {
		archivo = new FileOutputStream(nombreArchivo);
		escritura = new ObjectOutputStream(archivo);
	}
	
	public void Escribir(T objeto) throws IOException {
		if(escritura != null) {
			escritura.writeObject(objeto);
		}
	}
	
	public void Cerrar() throws IOException {
		if(escritura != null) {
			escritura.close();
		}
	}
}
