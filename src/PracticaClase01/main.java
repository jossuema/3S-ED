package PracticaClase01;

public class main {
	public static void main(String[] args) {
		Cliente cli  = new Cliente("0706209905", "Josue", 18, 1);
		Factura fact = new Factura(101, cli);
		
		char[][][] arreglo = {
				{ {'A', 'a'}, {'B', 'b'}, {'C', 'c'} },
				{ {'D', 'd'}, {'E', 'e'} },
				{ {'F', 'f'} }
				
		};
		
		System.out.println(arreglo.length);
		
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				for (int j2 = 0; j2 < arreglo[i][j].length; j2++) {
					System.out.print(arreglo[i][j][j2]+",");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
