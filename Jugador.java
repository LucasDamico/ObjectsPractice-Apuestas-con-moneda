package practicaClases;

public class Jugador {

	public String nombre;
	public int saldo=100;
	public Estado eleccion;
	public Booleano continuar;
	
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	
    void elegirCara(Estado eleccion) {
	    this.eleccion = eleccion;
	}	
    
    void elegirContinuar(Booleano continuar) {
	    this.continuar = continuar;
	}
    
}
