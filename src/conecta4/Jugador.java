package conecta4;

import java.util.Scanner;
import java.util.regex.Pattern;

class Jugador {
    int player;

    Jugador(int jugador) {
        this.player = jugador;
    }

    int turno(int[][] tablero) {
        boolean entradaCorrecta = false;
        Scanner sc = new Scanner(System.in);

        String posicion;
        do {
            System.out.print("\nES EL TURNO DE: ");
            if (this.player == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

            System.out.print("\nELIGE UNA COLUMNA: ");
            posicion = sc.next().toUpperCase();
            System.out.println("");
            if (Pattern.matches("[1-7]", posicion)) {
                entradaCorrecta = true;
            } else {
                System.out.println("La ficha no se puede colocar ahí porque está fuera del tablero :(\n¡Prueba de nuevo!");
            }
        } while(!entradaCorrecta);

        return Integer.parseInt(posicion);
    }
}