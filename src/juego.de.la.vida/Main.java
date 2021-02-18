package juego.de.la.vida;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main() {
        jugar();
    }

    public static void jugar() {
        Scanner in = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("J U E G O   D E   L A   V I D A");
            System.out.println("[J] Jugar");
            System.out.println("[T] Tutorial");
            System.out.println("[S] Salir");
            String entrada = in.next().toUpperCase();
            opcion = entrada.charAt(0);

            do {
                if (!Pattern.matches("[JTS]", entrada)) {
                    System.out.println("Entrada no válida. Por favor, introduce J para jugar o T para ver el tutorial.\nSi quieres salir, pulsa S.");
                }
            } while(!Pattern.matches("[JTS]", entrada));

            switch(opcion) {
                case 'T':
                    Juego.tutorial();
                    break;
                case 'S':
                    break;
                default:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Introduce las dimensiones del tablero.\nSi introduces 0 en el ancho y en el alto, se generará un tablero de 20x20 casillas:");
                    System.out.println("------------------------------------------------------------------------------");
            }

            int ancho;
            do {
                System.out.print("Ancho: ");
                entrada = in.next();
                if (Pattern.matches("[0-9]+", entrada)) {
                    ancho = Integer.parseInt(entrada);
                } else {
                    ancho = 0;
                }

                if (ancho > 100) {
                    System.out.println("Las dimensiones no pueden ser mayores que 100.");
                } else if (ancho < 0) {
                    System.out.println("Las dimensiones deben ser positivas");
                }
            } while(ancho < 0 || ancho > 100);

            int alto;
            do {
                System.out.print("Alto: ");
                entrada = in.next();
                if (Pattern.matches("[0-9]+", entrada)) {
                    alto = Integer.parseInt(entrada);
                } else {
                    alto = 0;
                }

                if (alto > 100) {
                    System.out.println("Las dimensiones no pueden ser mayores que 100.");
                } else if (alto < 0) {
                    System.out.println("Las dimensiones deben ser positivas.");
                }
            } while(alto < 0 || alto > 100);

            int ancho1, alto1, bichosVivos;
            do {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("Introduce el número de bichos vivos. Introduce 0 para que el número sea aleatorio: ");
                System.out.println("------------------------------------------------------------------------------");
                bichosVivos = Integer.parseInt(in.next());
                if (ancho > 0) {
                    ancho1 = ancho;
                } else {
                    ancho1 = 20;
                }

                if (alto > 0) {
                    alto1 = alto;
                } else {
                    alto1 = 20;
                }

                if (bichosVivos > ancho1 * alto1) {
                    System.out.println("El número es demasiado grande.");
                } else if (bichosVivos < 0) {
                    System.out.println("El número debe ser positivo.");
                }
            } while(bichosVivos > ancho1 * alto1);

            Juego sim;
            if (ancho == 0 && alto == 0 && bichosVivos == 0) {
                sim = new Juego();
            } else if (ancho != 0 && alto != 0 && bichosVivos == 0) {
                sim = new Juego(ancho, alto);
            } else if (ancho == 0 && alto == 0 && bichosVivos != 0) {
                sim = new Juego(bichosVivos);
            } else {
                sim = new Juego(ancho, alto, bichosVivos);
            }

            do {
                sim.imprimir();
                System.out.println("\n------------------------------------------------------------------------------");
                System.out.print("Introduce el número de generaciones o S para salir: ");
                entrada = in.next();
                System.out.println("------------------------------------------------------------------------------\n");

                if (Pattern.matches("[0-9]", entrada)) {
                    sim.simular(Integer.parseInt(entrada));
                } else if (!Pattern.matches("[Ss]", entrada)) {
                    System.out.println("Por favor, introduce un valor válido. Prueba de nuevo: ");
                }
            } while(!Pattern.matches("[Ss]", entrada));

            System.out.println("");
        } while(opcion != 'S');
    }
}