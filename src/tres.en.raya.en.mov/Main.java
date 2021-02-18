package tres.en.raya.en.mov;

import java.util.Scanner;

public class Main {
    public static void main() {
        jugar();
    }

    public static void jugar() {
        boolean valido = false;
        Scanner in = new Scanner(System.in);

        char opcion;
        do {
            System.out.println("T R E S   E N   R A Y A   E N   M O V I M I E N T O\n");
            System.out.println("[D] Dobles");
            System.out.println("[O] Máquina");
            System.out.println("[T] Tutorial");
            System.out.println("[S] Salir");

            do {
                opcion = in.next().toUpperCase().charAt(0);
                if (opcion != 'D' && opcion != 'O' && opcion != 'T' && opcion != 'S') {
                    System.out.println("Por favor, introduce D para jugar a dobles, O contra la máquina, T para ver el tutorial o S para salir.");
                } else {
                    switch (opcion) {
                        case 'D':
                            valido = true;
                            Juego.dobles();
                            break;
                        case 'O':
                            do {
                                System.out.println("¿Quieres que la IA sea aleatoria [R] o avanzada [A]? R/A");
                                opcion = in.next().toUpperCase().charAt(0);
                                if (opcion != 'R' && opcion != 'A') {
                                    System.out.println("Por favor, introduce R si quieres que la máquina sea aleatoria o A si quieres que sea avanzada. Pulsa S si deseas salir.");
                                } else {
                                    valido = true;
                                    switch (opcion) {
                                        case 'A':
                                            Juego.ia();
                                            break;
                                        case 'R':
                                            Juego.random();
                                    }
                                }
                            } while (!valido);
                            break;
                        case 'S':
                            valido = true;
                            break;
                        case 'T':
                            Juego.tutorial();
                            valido = true;
                    }
                }
            } while (!valido);
        } while (opcion != 'S');
    }
}