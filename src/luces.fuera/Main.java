package luces.fuera;

import java.util.Scanner;

public class Main {
    public static void main() {
        jugar();
    }


    public static void jugar() {
        boolean correcto = false;
        final Scanner sc = new Scanner(System.in);
        char option;
        do {
            System.out.println("L U C E S   F U E R A");
            System.out.println("\n[J] Jugar");
            System.out.println("[T] Tutorial");
            System.out.println("[S] Salir");
            do {
                option = sc.next().toUpperCase().charAt(0);
                if (option == 'J' || option == 'T' || option == 'S') {
                    switch (option) {
                        case 'J': {
                            correcto = true;
                            Juego.juego();
                            continue;
                        }
                        case 'T': {
                            Juego.tutorial();
                            correcto = true;
                            continue;
                        }
                        case 'S': {
                            correcto = true;
                            continue;
                        }
                    }
                } else {
                    System.out.println("Introduce J si quieres jugar, T para ver el tutorial o S para salir.");
                }
            } while (!correcto);
        } while (option != 'S');
    }
}
