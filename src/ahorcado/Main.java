package ahorcado;

import java.util.Scanner;

public class Main {
    public static void main() {
        jugar();
    }

    public static void jugar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A H O R C A D O\n");
        System.out.println("[J] Jugar");
        System.out.println("[T] Tutorial");
        System.out.println("[S] Salir");

        char opcion;
        do {
            String entrada = sc.next().toUpperCase();
            opcion = entrada.charAt(0);
            switch (opcion) {
                case 'T':
                    Juego.tutorial();
                    break;
                case 'S':
                    break;
                default:
                    Juego partida = new Juego();
                    partida.jugar();
                    System.out.print("Introduce un carácter cualquiera para volver a jugar o S para salir: ");
            }
        } while (opcion != 'S');
    }
}