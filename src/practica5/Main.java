package practica5;

import java.io.IOException;
import java.util.Scanner;
import archivos.Escritura;
import archivos.Lectura;
import tad.TADVector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        boolean ok = true;
		while (ok) {
			System.out.println("--------------SISTEMA DE REGISTRO DE VEHICULOS---------------");
			System.out.println("[1] Ingresar vehiculo");
			System.out.println("[2] Reporte de vehiculos");
			System.out.println("[3] Salida");
			String texto = scanner.nextLine();
			
			switch (texto) {
				case "1":
					ingresarVehiculos();
					break;
				case "2":
					leerVehiculos();
					break;
				case "3":
					System.out.println("---------------------PROGRAMA FINALIZADO--------------------");
					ok = false;
					break;
				default:
					System.out.println("Ingrese una opcion valida");
			}
		}
	}
	
	public static void ingresarVehiculos() {
		Scanner scanner = new Scanner(System.in);
		Vehiculo vh = new Vehiculo();
		int n;
		
		while(true) {
			System.out.println("Ingrese la cantidad de vehiculos a guardar: ");
			System.out.println("Para salir ingrese [0]");
			String txt = scanner.nextLine();
			
			if(txt.equals("0")) {
				break;
			}
			
			try {
				n = Integer.valueOf(txt);
			}catch(NumberFormatException x) {
				continue;
			}
			
			for (int i = 0; i < n; i++) {
				vh = Registro();
				System.out.println("------------------------GUARDANDO INFORMACION DEL VEHICULO--------------------------");
				guadarVehiculo(vh);
			}
		
		}
	}
	
	public static Vehiculo Registro(){
		Scanner scanner = new Scanner(System.in);
		Vehiculo vh = new Vehiculo();
		Propietario pr = new Propietario();
		
		System.out.println("---------------NUEVO VEHICULO----------------");
		System.out.println("Ingrese el VIN (Debe contener 17 caracteres):");
		while(true) {
			String texto =  scanner.nextLine();
			if(texto.length()==17) {
				vh.setVIN(texto);
				break;
			}
			System.out.println("Ingresa correctamente el VIN (Debe contener 17 caracteres)");
		}
		
		System.out.println("Ingrese la marca del vehiculo:");
		vh.setMarca(scanner.nextLine());
		
		System.out.println("Ingrese el modelo del vehiculo:");
		vh.setModelo(scanner.nextLine());
		
		System.out.println("Ingrese el numero de pasajeros:");
		while(true) {
			String texto = scanner.nextLine();
			try {
				vh.setNumerosPasajeros(Integer.valueOf(texto));
				break;
			}catch(NumberFormatException ex) {
				System.out.println("!!Ingrese un numero");
			}
		}
		
		System.out.println("Ingrese el valor del vehiculo:");
		while(true) {
			String texto = scanner.nextLine();
			try {
				vh.setValor(Double.valueOf(texto));
				break;
			}catch(NumberFormatException ex) {
				System.out.println("!!Ingrese una cantidad numerica");
			}
		}
		
		System.out.println("Ingrese el año del vehiculo:");
		while(true) {
			String texto = scanner.nextLine();
			try {
				vh.setAnio(Integer.valueOf(texto));;
				break;
			}catch(NumberFormatException ex) {
				System.out.println("!!Ingrese un año");
			}
		}
		
		System.out.println("INFORMACION DEL PROPIETARIO");
		System.out.println("Ingrese la cedula del dueño:");
		pr.setCedula(scanner.nextLine());
		
		System.out.println("Ingrese los nombres del dueño:");
		pr.setNombre(scanner.nextLine());
		
		vh.setDueno(pr);
		return vh;
	}
	
	public static void guadarVehiculo(Vehiculo vh) {
		String nombreArchivo = "Vehiculos.dat";
		TADVector<Vehiculo> tad = getVehiculos(nombreArchivo);
		Escritura<Vehiculo> salida = new Escritura<>(nombreArchivo);
		
		//ESCRIBIR NUEVO VEHICULO Y VEHICULOS DEL AUXILIAR
		try {
			salida.Abrir();
			salida.Escribir(vh);
			for (int i = 0; i < tad.getLongitud(); i++) {
				salida.Escribir(tad.leerElemento(i));;
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				salida.Cerrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void leerVehiculos() {
		String nombreArchivo = "Vehiculos.dat";
		TADVector<Vehiculo> tad = getVehiculos(nombreArchivo);
		
		System.out.println("\nVehiculos:");
		for (int i = 0; i < tad.getLongitud(); i++) {
			System.out.println("("+i+") "+ tad.leerElemento(i));
		}
	}
	
	public static TADVector<Vehiculo> getVehiculos(String txt){
		Lectura<Vehiculo> entrada = new Lectura<>(txt);
		TADVector<Vehiculo> tad = new TADVector<>(entrada.LongitudArchivo(), txt);
		
		try {
			entrada.Abrir();
			for (int i = 0; i < tad.getLongitud(); i++) {
				tad.ingresarElemento(entrada.Leer());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				entrada.Cerrar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return tad;
	}

}
