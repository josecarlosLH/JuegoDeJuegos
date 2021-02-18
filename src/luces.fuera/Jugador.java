package luces.fuera;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Jugador
{
    static String turno() {
        final Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        String entrada;
        do {
            entrada = sc.next().toUpperCase();
            if (Pattern.matches("([A-E][1-5])|([S])", entrada)) {
                if (entrada.equalsIgnoreCase("S")) {
                    entrada = "S0";
                }
                correcto = true;
            }
            else {
                System.out.println("Entrada incorrecta.");
            }
        } while (!correcto);
        return entrada;
    }
}