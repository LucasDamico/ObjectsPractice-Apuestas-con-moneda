package practicaClases;

import java.util.InputMismatchException; 
import java.util.Scanner;

public class Principal {
	static Scanner s = new Scanner(System.in); 
	
	public static void main(String[] args) {
		Maquina maq = new Maquina(0);
		Jugador jugador; 
		
		System.out.println("Bienbenido jugador, ingrese su nombre:");
		jugador = new Jugador(s.nextLine());
		
		System.out.println("Hola " + jugador.nombre + " Tu saldo es de " + jugador.saldo);
		
		do {
			System.out.println("¿Cuanto deseas apostar?");
		    maq.apuesta =valorarEnteroApuesta(1,jugador.saldo);
        
		    System.out.println("Elige: ¿Cara, seca o... canto?");
		    jugador.eleccion=valorarEstado();
		
            maq.lanzarMoneda();
        
            jugador.saldo+=(jugador.eleccion==maq.moneda.cara)? (jugador.eleccion==Estado.CANTO)?maq.apuesta*100 : maq.apuesta  : -maq.apuesta;
            System.out.println("Tu saldo actual es de " + jugador.saldo);
            System.out.println();
            
            if(jugador.saldo!=0) {
                System.out.println("¿Quieres volver a jugar?\n Elige: ¿Si o no?");
                jugador.continuar= valorarBooleano();
            } else {
        	System.out.println("Te has quedado sin dinero, no puedes seguir jugando");
        	jugador.continuar=Booleano.NO;
            }
        
    }while(jugador.continuar==Booleano.SI);
	
		System.out.println("[Tu saldo final es " + jugador.saldo + "]");
	}//Main
	
	public static Estado valorarEstado() {
		Estado estado= Estado.CARA;
		boolean error=false;
		s.nextLine();

		do {
			error=false;
			try {
				estado = Estado.valueOf(s.nextLine().toUpperCase());
				
			}catch(IllegalArgumentException e) {
				
				System.out.println("[ERROR] Ingrese cara, seca o canto");
				error=true;
			}catch(Exception e) {
				System.out.println("[ERROR] Error inesperado: " + e);
				error=true;
				
			}
				
		}while(error);
		return estado;
	}
	
	public static Booleano valorarBooleano() {
		Booleano booleano= Booleano.SI;
		boolean error=false;
		
		do {
			error=false;
			try {
				booleano = Booleano.valueOf(s.nextLine().toUpperCase());
			}catch(IllegalArgumentException e) {
				
				System.out.println("[ERROR] Ingrese si o no");
				error=true;
			}catch(Exception e) {
				System.out.println("[ERROR] Error inesperado: " + e);
				error=true;
				
			}
			
		}while(error);
		return booleano;
	}
	
	public static int valorarEnteroApuesta(int min, int max) {
		int entero=0;
		boolean error= false;
	
		do {
			error=false;
			try {
		       entero=s.nextInt();
		       if(entero<min){
					System.out.println("No puedes apostar una cantidad menor que " + min );
                    error=true;
		       }else if(entero >max) {
		    	   System.out.println("No puedes apostar esa cantidad, se que no tienes es dinero");
                   error=true;

		       }
			} 
			catch(InputMismatchException e) {
				System.out.println("[ERROR] Ingrese un número válido");
				s.nextLine();
				error=true;
			}
			catch(Exception e) {
				System.out.println("[ERROR] Error inesperado" + e);
				s.nextLine();
                error=true;
			}
		}while(error);
		
		return entero;
	}
}//Class
