package tres.en.raya.clasico;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Jugador {
    int player;

    public Jugador(int numJugador) {
        this.player = numJugador;
    }

    public void turno(int[][] tablero) {
        boolean entradaCorrecta = false;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("\nES EL TURNO DE: ");
            if (this.player == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

            System.out.print("\nELIGE UNA CASILLA: ");
            String posicion = in.next().toUpperCase();
            System.out.println("");
            if (Pattern.matches("[A-C][1-3]", posicion)) {
                if (tablero[Juego.seleccionarCasillaEjeY(posicion)][Juego.seleccionarCasillaEjeX(posicion)] == 0) {
                    tablero[Juego.seleccionarCasillaEjeY(posicion)][Juego.seleccionarCasillaEjeX(posicion)] = this.player;
                    entradaCorrecta = true;
                } else {
                    System.out.println("Ya hay una ficha en esa casilla.");
                }
            } else {
                System.out.println("La ficha no se puede colocar ahí porque está fuera del tablero :(\n¡Prueba de nuevo!");
            }
        } while(!entradaCorrecta);
    }
}