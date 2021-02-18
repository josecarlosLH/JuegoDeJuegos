package juego.de.juegos;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        conecta4.Main conecta4 = new conecta4.Main();
        tres.en.raya.clasico.Main terc = new tres.en.raya.clasico.Main();
        tres.en.raya.en.mov.Main terem = new tres.en.raya.en.mov.Main();
        ahorcado.Main ahor = new ahorcado.Main();
        luces.fuera.Main luces = new luces.fuera.Main();
        juego.de.la.vida.Main juegovida = new juego.de.la.vida.Main();

        String entrada;
        do {
            System.out.println("\n-----------------------------------------------------------------------------");
            System.out.println("¡BIENVENIDO AL JUEGO DE LOS JUEGOS!");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("[1] Tres en raya clásico");
            System.out.println("[2] Tres en raya en movimiento");
            System.out.println("[3] Ahorcado");
            System.out.println("[4] Conecta 4");
            System.out.println("[5] Luces Fuera");
            System.out.println("[6] El juego de la vida");
            System.out.println("[S] Salir");
            System.out.println("-----------------------------------------------------------------------------");
            entrada = sc.next();

            do {
                if (!Pattern.matches("[Ss1-6]", entrada)) {
                    System.out.println("Entrada no válida. Por favor, introduce un número\ndel 1 al 5 que se corresponda con el juego que quieres seleccionar.\nSi quieres salir, pulsa S.");
                }
            } while(!Pattern.matches("[Ss1-6]", entrada));

            switch(entrada.charAt(0)) {
                case '1':
                    System.out.println("-----------------------------------------------------------------------------");
                    terc.jugar();
                    break;
                case '2':
                    System.out.println("-----------------------------------------------------------------------------");
                    terem.jugar();
                    break;
                case '3':
                    System.out.println("-----------------------------------------------------------------------------");
                    ahor.jugar();
                    break;
                case '4':
                    System.out.println("-----------------------------------------------------------------------------");
                    conecta4.jugar();
                    break;
                case '5':
                    System.out.println("-----------------------------------------------------------------------------");
                    luces.jugar();
                    break;
                case '6':
                    System.out.println("-----------------------------------------------------------------------------");
                    juegovida.jugar();
            }
        } while(entrada.toUpperCase().charAt(0) != 'S');
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Has salido. ¡Esperamos verte pronto!");
        System.out.println("-----------------------------------------------------------------------------");
    }
}