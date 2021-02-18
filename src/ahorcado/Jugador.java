package ahorcado;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Jugador {
    public static char turno() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nINTRODUCE UNA LETRA: ");

        String entrada;
        do {
            entrada = in.next();
            if (!Pattern.matches("[A-Za-z]", entrada)) {
                System.out.print("Sólo se introducen letras. Prueba otra vez: ");
            }
        } while(!Pattern.matches("[A-Za-z]", entrada));

        System.out.println("");
        entrada = entrada.toUpperCase();
        return entrada.charAt(0);
    }
}