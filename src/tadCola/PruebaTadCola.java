package tadCola;

public class PruebaTadCola {
	public static void main(String[] args) {
		Cola<Integer> cola1 = new TadCola<>();
		
		cola1.encolar(8);
		cola1.encolar(7);
		cola1.encolar(2);
		cola1.imprimirCola();
		
		try {
			System.out.println("El primero de la cola es: "+cola1.primero());
			System.out.println("Y tiene "+cola1.numElemCola()+" elementos");
			int dato = cola1.desencolar();
			System.out.println("Se desencolo el "+dato);
			cola1.imprimirCola();
			cola1.invertirCola();
			System.out.println("Se invirtio la cosa");
			cola1.imprimirCola();
			System.out.println(cola1.busqueda(8));
			cola1.imprimirCola();
		} catch (ColaVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
