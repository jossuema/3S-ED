package tallerCola;

import java.util.Random;

public class Tarea implements Comparable<Tarea>{
	
	private int marcaTiempo;
	private int paginas;
	
	public Tarea(int tiempo) {
        this.marcaTiempo = tiempo;
        Random rand = new Random();
        this.paginas = rand.nextInt(20) + 1; //de 1 a 20
    }

    public int obtenerMarca() {
        return this.marcaTiempo;
    }

    public int obtenerPaginas() {
        return this.paginas;
    }

    public int tiempoEspera(int tiempoActual) {
    	return tiempoActual - marcaTiempo;
         // 	Restar marcaTiempo de tiempoActual
    }

	@Override
	public int compareTo(Tarea o) {
		// TODO Auto-generated method stub
		return this.paginas - o.obtenerPaginas();
	}

}
