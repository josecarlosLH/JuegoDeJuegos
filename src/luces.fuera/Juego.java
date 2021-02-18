package luces.fuera;

import java.util.Scanner;

class Juego {
    static void juego() {
        final Tablero tablero = new Tablero();
        final Scanner in = new Scanner(System.in);
        int intento = 0;
        tablero.randomizar();
        int x = 0;
        int y = 0;
        do {
            tablero.print();
            System.out.println("INTENTOS: " + intento);
            final String input = Jugador.turno();
            switch (input.charAt(0)) {
                case 'A': {
                    y = 0;
                    break;
                }
                case 'B': {
                    y = 1;
                    break;
                }
                case 'C': {
                    y = 2;
                    break;
                }
                case 'D': {
                    y = 3;
                    break;
                }
                case 'E': {
                    y = 4;
                    break;
                }
                default: {
                    y = -1;
                    break;
                }
            }
            switch (input.charAt(1)) {
                case '1': {
                    x = 0;
                    break;
                }
                case '2': {
                    x = 1;
                    break;
                }
                case '3': {
                    x = 2;
                    break;
                }
                case '4': {
                    x = 3;
                    break;
                }
                case '5': {
                    x = 4;
                    break;
                }
                default: {
                    x = -1;
                    break;
                }
            }
            if (x != -1 && y != -1) {
                tablero.click(x, y);
            }
            ++intento;
        } while (x != -1 && y != -1);
        System.out.println("Has decidido salir. ¿Deseas ver la soluciónn? (si/no)");
        String entrada;
        do {
            entrada = in.next();
            if (!entrada.equalsIgnoreCase("no") && !entrada.equalsIgnoreCase("si")) {
                System.out.println("Entrada no válida. Por favor, inténtalo de nuevo");
            }
        } while (!entrada.equalsIgnoreCase("no") && !entrada.equalsIgnoreCase("si"));
        if (entrada.equalsIgnoreCase("si")) {
            tablero.resolucion();
        }
    }

    static void tutorial() {
        final Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                             L U C E S   F U E R A");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------- REGLAS DE JUEGO ------------------------------");
        System.out.println("En el juego se presenta un tablero con casillas que pueden contener");
        System.out.println("(X) encendida (O) apagada. Tu objetivo será que todo el tablero esté");
        System.out.println("apagado (O). En cada turno, podrás invertir una casilla, al igual que");
        System.out.println("sus casillas vecinas (arriba, abajo, derecha e izquierda).");
        System.out.println("\nSi quieres modificar una casilla, tienes que introducir");
        System.out.println("la letra y número que se le corresponde. Ej: C2, A3");
        System.out.println("\nSi te has rendido y quieres ver la solución, ");
        System.out.println("introduce \"S\" para salir y poder verla.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Introduce un caracter para continuar: ");
        sc.next();
        System.out.println(" ");
    }
}


