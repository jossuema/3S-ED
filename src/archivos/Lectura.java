package archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Lectura<T>{
	
	private String nombreArchivo;
	private FileInputStream archivo;
	private ObjectInputStream lectura;
	
	public Lectura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}
	
	public void Abrir() throws IOException {
		archivo = new FileInputStream(nombreArchivo);
		lectura = new ObjectInputStream(archivo);
		
	}
	
	public int LongitudArchivo() {
		int i = 0;
		try {
			Abrir();
			while(Leer()!=null) {
				i++;
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				Cerrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public T Leer() throws ClassNotFoundException, IOException{
		try {
			return (T) lectura.readObject();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			return null;
		} 
	}
	
	public void Cerrar() throws IOException {
		if(lectura!=null)
		lectura.close();
	}
	
}
