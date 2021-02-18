package conecta4;

import java.util.Scanner;

class Juego {
    static void dobles() {
        Tablero tablero = new Tablero();
        Scanner in = new Scanner(System.in);
        Jugador p1 = new Jugador(1);
        Jugador p2 = new Jugador(2);
        tablero.imprimirTablero();

        while(tablero.ganador() == 0) {
            if (tablero.ganador() == 0) {
                while(!tablero.colocarX(p1.turno(tablero.tablero))) {
                    System.out.println("LA COLUMNA ESTÁ LLENA.");
                }

                tablero.imprimirTablero();
            }

            if (tablero.ganador() == 0) {
                while(!tablero.colocarO(p2.turno(tablero.tablero))) {
                    System.out.println("LA COLUMNA ESTÁ LLENA.");
                }

                tablero.imprimirTablero();
            }

            System.out.println("\n-----------------------------------------------------------------------------");

            switch(tablero.ganador()) {
                case 1:
                    System.out.println("¡JUGADOR 1 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    in.next();
                    break;
                case 2:
                    System.out.println("¡JUGADOR 2 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    in.next();
                    break;
                case 3:
                    System.out.println("¡EMPATE!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    in.next();
            }
        }

    }

    static void random() {
        Tablero tablero = new Tablero();
        Scanner sc = new Scanner(System.in);
        Jugador p1 = new Jugador(1);
        tablero.imprimirTablero();

        while(tablero.ganador() == 0) {
            if (tablero.ganador() == 0) {
                tablero.colocarX(p1.turno(tablero.tablero));
                tablero.imprimirTablero();
            }

            if (tablero.ganador() == 0) {
                int posicion;
                do {
                    posicion = (int)(Math.random() * 7.0D) + 1;
                } while(!tablero.colocarO(posicion));

                tablero.imprimirTablero();
            }

            System.out.println("\n-----------------------------------------------------------------------------");

            switch(tablero.ganador()) {
                case 1:
                    System.out.println("¡JUGADOR 1 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
                    break;
                case 2:
                    System.out.println("¡JUGADOR 2 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
                    break;
                case 3:
                    System.out.println("¡EMPATE!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
            }
        }

    }

    static void ia() {
        Tablero tablero = new Tablero();
        Scanner sc = new Scanner(System.in);
        Jugador p1 = new Jugador(1);
        tablero.imprimirTablero();

        while(tablero.ganador() == 0) {
            if (tablero.ganador() == 0) {
                tablero.colocarX(p1.turno(tablero.tablero));
                tablero.imprimirTablero();
            }

            if (tablero.ganador() == 0) {
                String situacion = IA.aPuntoDeGanar(tablero.tablero);
                int position;
                if (situacion.charAt(0) == 'T') {
                    tablero.colocarO(situacion.charAt(2) - 48);
                } else {
                    do {
                        position = (int)(Math.random() * 7.0D) + 1;
                    } while(!tablero.colocarO(position));
                }
                tablero.imprimirTablero();
            }

            System.out.println("\n-----------------------------------------------------------------------------");

            switch(tablero.ganador()) {
                case 1:
                    System.out.println("¡JUGADOR 1 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
                    break;
                case 2:
                    System.out.println("¡JUGADOR 2 GANA!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
                    break;
                case 3:
                    System.out.println("¡EMPATE!");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Introduce un caracter para continuar: ");
                    sc.next();
            }
        }
    }

    static void tutorial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              C O N E C T A   4");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------- REGLAS DE JUEGO ------------------------------");
        System.out.println("Tendrás que ser capaz de enlazar 4 fichas consecutivas, ya sea de forma");
        System.out.println("horizontal, vertical o diagonal. Para elegir la casilla en la que quieres");
        System.out.println("escribir, introduce el número correspondiente a la columna que selecciones.");
        System.out.println("------------------------------- MODOS DE JUEGO -------------------------------");
        System.out.println("· A DOBLES:");
        System.out.println("En este modo podrás jugar contra un amigo de forma local.");
        System.out.println("Las casillas se introducen por turnos.");
        System.out.println("\n· CONTRA LA MÁQUINA:");
        System.out.println("El comportamiento de la máquina dependerá de si has elegido jugar contra");
        System.out.println("inteligencia arficial o juego aleatorio. El último símplemente eligirá");
        System.out.println("casillas aleatorias, pero la inteligencia artificial se defenderá de");
        System.out.println("tus movimientos e intentará arrebatarte la victoria.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Introduce un caracter para continuar: ");
        sc.next();
        System.out.println(" ");
    }
}