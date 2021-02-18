package tres.en.raya.en.mov;

import java.util.Scanner;

public class Juego {
    public static int selecCasillaEjeY(String position) {
        int y = 0;
        String var2 = String.valueOf(position.charAt(0));
        byte var3 = -1;
        switch(var2.hashCode()) {
            case 65:
                if (var2.equals("A")) {
                    var3 = 0;
                }
                break;
            case 66:
                if (var2.equals("B")) {
                    var3 = 1;
                }
                break;
            case 67:
                if (var2.equals("C")) {
                    var3 = 2;
                }
        }

        switch(var3) {
            case 0:
                y = 0;
                break;
            case 1:
                y = 1;
                break;
            case 2:
                y = 2;
        }

        return y;
    }

    public static int selecCasillaX(String position) {
        int x = 0;
        String var2 = String.valueOf(position.charAt(1));
        byte var3 = -1;
        switch(var2.hashCode()) {
            case 49:
                if (var2.equals("1")) {
                    var3 = 0;
                }
                break;
            case 50:
                if (var2.equals("2")) {
                    var3 = 1;
                }
                break;
            case 51:
                if (var2.equals("3")) {
                    var3 = 2;
                }
        }

        switch(var3) {
            case 0:
                x = 0;
                break;
            case 1:
                x = 1;
                break;
            case 2:
                x = 2;
        }

        return x;
    }

    public static void dobles() {
        Tablero tablero = new Tablero();
        Scanner sc = new Scanner(System.in);
        Jugador p1 = new Jugador(1);
        Jugador p2 = new Jugador(2);
        int numTurno = 1;
        tablero.imprimir();

        while(tablero.ganador() == 0) {
            if (numTurno < 4) {
                if (tablero.ganador() == 0) {
                    p1.turnoClasico(tablero.tablero);
                    tablero.imprimir();
                }

                if (tablero.ganador() == 0) {
                    p2.turnoClasico(tablero.tablero);
                    ++numTurno;
                    tablero.imprimir();
                }
            } else {
                if (tablero.ganador() == 0) {
                    p1.turnoMoviendo(tablero.tablero);
                    tablero.imprimir();
                }

                if (tablero.ganador() == 0) {
                    p2.turnoMoviendo(tablero.tablero);
                    ++numTurno;
                    tablero.imprimir();
                }
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

    public static void ia() {
        Tablero tablero = new Tablero();
        Jugador p1 = new Jugador(1);
        Jugador ia = new Jugador(2);
        Scanner sc = new Scanner(System.in);
        int numTurno = 1;
        tablero.imprimir();

        while(tablero.ganador() == 0) {
            if (numTurno < 4) {
                if (tablero.ganador() == 0) {
                    p1.turnoClasico(tablero.tablero);
                    tablero.imprimir();
                }

                if (tablero.aPuntoDeGanar() == 20) {
                    int x;
                    int y;
                    do {
                        x = (int)(Math.random() * 3.0D);
                        y = (int)(Math.random() * 3.0D);
                    } while(tablero.tablero[y][x] != 0);

                    tablero.tablero[y][x] = 2;
                } else {
                    switch(tablero.aPuntoDeGanar()) {
                        case 0:
                            tablero.tablero[0][2] = 2;
                            break;
                        case 1:
                            tablero.tablero[0][1] = 2;
                            break;
                        case 2:
                            tablero.tablero[2][2] = 2;
                            break;
                        case 3:
                            tablero.tablero[1][1] = 2;
                            break;
                        case 4:
                            tablero.tablero[2][0] = 2;
                            break;
                        case 5:
                            tablero.tablero[1][0] = 2;
                            break;
                        case 6:
                            tablero.tablero[0][0] = 2;
                            break;
                        case 7:
                            tablero.tablero[2][0] = 2;
                            break;
                        case 8:
                            tablero.tablero[1][1] = 2;
                            break;
                        case 9:
                            tablero.tablero[2][2] = 2;
                            break;
                        case 10:
                            tablero.tablero[1][2] = 2;
                            break;
                        case 11:
                            tablero.tablero[2][1] = 2;
                            break;
                        case 12:
                            tablero.tablero[1][1] = 2;
                            break;
                        case 13:
                            tablero.tablero[0][1] = 2;
                            break;
                        case 14:
                            tablero.tablero[1][2] = 2;
                            break;
                        case 15:
                            tablero.tablero[1][1] = 2;
                            break;
                        case 16:
                            tablero.tablero[1][0] = 2;
                            break;
                        case 17:
                            tablero.tablero[2][2] = 2;
                            break;
                        case 18:
                            tablero.tablero[2][1] = 2;
                            break;
                        case 19:
                            tablero.tablero[2][0] = 2;
                    }
                }

                tablero.imprimir();
            } else {
                if (tablero.ganador() == 0) {
                    p1.turnoMoviendo(tablero.tablero);
                    tablero.imprimir();
                }

                if (tablero.ganador() == 0) {
                    ia.turnoMovRandom(tablero.tablero);
                    tablero.imprimir();
                }
            }

            System.out.println("\n-----------------------------------------------------------------------------");

            ++numTurno;
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

    public static void random() {
        Tablero board = new Tablero();
        Jugador p1 = new Jugador(1);
        Jugador ia = new Jugador(2);
        Scanner sc = new Scanner(System.in);
        int numTurno = 1;
        board.imprimir();

        while(board.ganador() == 0) {
            if (numTurno < 4) {
                if (board.ganador() == 0) {
                    p1.turnoClasico(board.tablero);
                    board.imprimir();
                }

                if (board.ganador() == 0) {
                    int x;
                    int y;
                    do {
                        x = (int)(Math.random() * 3.0D);
                        y = (int)(Math.random() * 3.0D);
                    } while(board.tablero[y][x] != 0);

                    board.tablero[y][x] = 2;
                    board.imprimir();
                }

                board.imprimir();
            } else {
                if (board.ganador() == 0) {
                    p1.turnoMoviendo(board.tablero);
                    board.imprimir();
                }

                if (board.ganador() == 0) {
                    ia.turnoMovRandom(board.tablero);
                    board.imprimir();
                }
            }

            System.out.println("\n-----------------------------------------------------------------------------");

            ++numTurno;
            switch(board.ganador()) {
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
                    sc.next();
            }
        }

    }

    public static void tutorial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                T R E S   E N   R A Y A   E N   M O V M I E N T O");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------- REGLAS DE JUEGO ------------------------------");
        System.out.println("Para elegir la casilla en la que quieres escribir, introduce la letra");
        System.out.println("de la fila (A-C) seguida del número de la columna (1-3), por ejemplo \"A1\".");
        System.out.println("A partir del 4º turno no podrás añadir más fichas al tablero, por lo que ");
        System.out.println("tendrás que mover las que ya tienes en el tablero. Para ello, selecciona ");
        System.out.println("primero una de tus fichas que quieres mover y muévela con W, A, S o D.");
        System.out.println("------------------------------- MODOS DE JUEGO -------------------------------");
        System.out.println("· A DOBLES:");
        System.out.println("En este modo podrás jugar contra un amigo de forma local.");
        System.out.println("Las casillas se introducen por turnos.");
        System.out.println("\n· CONTRA LA MÁQUINA:");
        System.out.println("En este modo jugarás contra la máquina, cuyo comportamiento dependerá de si");
        System.out.println("has elegido jugar contra inteligencia arficial o juego aleatorio.");
        System.out.println("El último símplemente eligirá casillas aleatorias, pero la inteligencia");
        System.out.println("artificial se defenderá de tus intentos de ganar.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Introduce un caracter para continuar: ");
        sc.next();
        System.out.println(" ");
    }
}