package conecta4;

import java.util.Scanner;

public class Main {

    public static void main() {
        jugar();
    }

    public static void jugar() {
        boolean correcto = false;
        Scanner sc = new Scanner(System.in);

        char opcion;
        do {
            System.out.println("C O N E C T A   4");
            System.out.println("\n[D] Dobles");
            System.out.println("[O] Máquina");
            System.out.println("[T] Tutorial");
            System.out.println("[S] Salir");

            do {
                opcion = sc.next().toUpperCase().charAt(0);
                if (opcion != 'D' && opcion != 'O' && opcion != 'T' && opcion != 'S') {
                    System.out.println("Por favor, introduce D para jugar a dobles, O para jugar contra la máquina, T para ver el tutorial o S para salir.");
                } else {
                    switch (opcion) {
                        case 'D':
                            correcto = true;
                            Juego.dobles();
                            break;
                        case 'O':
                            do {
                                System.out.println("¿Quieres que la IA sea aleatoria [R] o avanzada [A]? (R/A)");
                                opcion = sc.next().toUpperCase().charAt(0);
                                if (opcion != 'R' && opcion != 'A') {
                                    System.out.println("Por favor, introduce R para aleatoria o A para avanzada. En caso de que quieras salir, pulsa S.");
                                } else {
                                    correcto = true;
                                    switch (opcion) {
                                        case 'A':
                                            Juego.ia();
                                            break;
                                        case 'R':
                                            Juego.random();
                                    }
                                }
                            } while (!correcto);
                            break;
                        case 'S':
                            correcto = true;
                            break;
                        case 'T':
                            Juego.tutorial();
                            correcto = true;
                    }
                }
            } while (!correcto);
        } while (opcion != 'S');
    }
}