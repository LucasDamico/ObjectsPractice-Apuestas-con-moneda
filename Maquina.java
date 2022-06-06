package practicaClases;

import java.util.Random;

public class Maquina {

	Moneda moneda = new Moneda(); 
	int apuesta;

public Maquina (int apuesta) {
	this.apuesta=apuesta;
  } 

public void lanzarMoneda() {
	Random r = new Random();
    int cara=r.nextInt(200);
    
    if(cara<99) {
        moneda.cara=Estado.CARA;
    } else if(cara<198) {
		moneda.cara=Estado.SECA;
    } else {
		moneda.cara=Estado.CANTO;
    }
	
	System.out.println("Ha salido " + moneda.cara);
    }
}