package tallerCola;

public class Impresora {
	
	private int tasaPaginas;
	private int tiempoRestante;
	private Tarea tareaActual;
	
	public Impresora(int paginas) {
        this.tasaPaginas = paginas;
        this.tareaActual = null;
        this.tiempoRestante = 0;
    }

    public void tictac() {
        if (this.tareaActual != null) {
            this.tiempoRestante = this.tiempoRestante - 1;
            if (this.tiempoRestante == 0) {
                this.tareaActual = null;
            }
        }
    }

    public boolean ocupada() {
        return this.tareaActual != null;
    }

    public void iniciarNueva(Tarea nuevaTarea) {
        this.tareaActual = nuevaTarea;
        this.tiempoRestante = (int) ((Double.valueOf(nuevaTarea.obtenerPaginas()) / Double.valueOf(this.tasaPaginas))*60); // Cálculo de tiempo requerido por tarea
    }

}
