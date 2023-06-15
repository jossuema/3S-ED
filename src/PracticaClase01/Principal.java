package PracticaClase01;

public class Principal {

	public static void main(String[] args) {
		String st1="Hola";
		String st2="Mundo";
		StringBuffer palabra = new StringBuffer("Hola");
		
		char[][][] arreglo = {{{'A', 'a'}, {'B', 'b'}, {'C', 'c'}}, 
							  {{'D', 'd'}, {'E', 'e'}}, 
							  {{'F', 'f'}}};
		Cliente cli = new Cliente("0702739228", "Fausto Redrov�n", 50, 1);
		Factura fact = new Factura(101, cli);
		
		System.out.println(fact);
		
		/*char[] vector = new char[3];
		char[][] matriz = new char[3][];
		matriz[0] = new char[3];
		matriz[1] = new char[2];
		matriz[2] = new char[1];*/
		char[][][] cubo = new char[3][][];
		cubo[0] = new char[3][2];
		cubo[1] = new char[2][2];
		cubo[2] = new char[1][2];
		System.out.println(arreglo[0][0][0]);
		
		for(int i=0; i<arreglo.length; i++) {
			for(int j=0; j<arreglo[i].length; j++) {
				for(int k=0; k<arreglo[i][j].length; k++) {
					System.out.print(arreglo[i][j][k] + " ");					
				}
			}
			System.out.println();	
		}
		
		System.out.println(st1 + " " + st2);
		palabra.append(" ");
		palabra.append("Mundo");
		System.out.println(palabra);

	}
	


}
