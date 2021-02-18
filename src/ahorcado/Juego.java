package ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    Scanner sc;
    String palabra, listaPalabras;
    Random rnd;

    public Juego() {
        this.sc = new Scanner(System.in);
        this.palabra = "";
        this.listaPalabras = "ARTISTA CRACK MASTODONTE PEDIATRA LÍDER ARGUIÑANO ANCHOA SOMBRERO HEROÍNA PUDOR VIGOR RIGOR CONSTANCIA ESFUERZO DEDICACIÓN MATÍAS ANTONIO NICOLÁS ISLA CAMPAÑA CAMARÓN POBLADO DICTADURA MONEDA VEJIGA MANO SEIS URETRA OESTE TOCAR GOLPEAR ANTIGÜEDAD PINGÜINO HABICHUELA HABAS REFRESCO MIEDO TENSIÓN PÁNICO DIRECTO COCHE MOTO TALADRO PICAR DIAMANTE PALA ANSIEDAD DEFENDER ESCRIBIR CATALUÑA GLOBO AURICULARES PRESIÓN BABOSA CARACOL SALTAMONTES MONTAR SILLA COGER CABALLO PÁJARO DOLOR AGUJA CORRER ZAPATILLAS LITERATURA INSOPORTABLE LEVEDAD SER PROTAGONISTA BEBER NARANJA AGUA PERÚ EXISTIR PARAGUAY VILLA";
        this.rnd = new Random();
    }

    public void dibujarAhorcado(int num) {
        switch(num) {
            case 0:
                System.out.println("\n\n\n\n\n\n");
                break;
            case 1:
                System.out.println("\n\n\n\n|\n|");
                break;
            case 2:
                System.out.println("\n|\n|\n|\n|\n|");
                break;
            case 3:
                System.out.println(" ----\n|\n|\n|\n|\n|");
                break;
            case 4:
                System.out.println(" ----\n|    |\n|\n|\n|\n|");
                break;
            case 5:
                System.out.println(" ----\n|    |\n|   \\O/\n|\n|\n|");
                break;
            case 6:
                System.out.println(" ----\n|    |\n|   \\O/\n|    |\n|\n|");
                break;
            case 7:
                System.out.println(" ----\n|    |\n|   \\O/\n|    |\n|   / \\\n|\n\n");
        }
        System.out.println("");
    }

    public boolean ganar(char[] jugador, char[] palabraDiv) {
        boolean ganar = true;

        for(int i = 0; i < this.palabra.length(); ++i) {
            if (jugador[i] != palabraDiv[i]) {
                ganar = false;
                break;
            }
        }

        return ganar;
    }

    public void jugar() {
        int cont;
        if (this.listaPalabras.length() > 5) {
            cont = this.rnd.nextInt(this.listaPalabras.length() - 6);
        } else {
            cont = this.rnd.nextInt(this.listaPalabras.length());
        }

        char caractActual;
        do {
            caractActual = this.listaPalabras.charAt(cont);
            ++cont;
        } while(caractActual != ' ');

        for(caractActual = this.listaPalabras.charAt(cont); caractActual != ' '; caractActual = this.listaPalabras.charAt(cont)) {
            this.palabra = this.palabra + caractActual;
            ++cont;
        }

        char[] palabraDiv = new char[this.palabra.length()];

        for(int i = 0; i < this.palabra.length(); ++i) {
            palabraDiv[i] = this.palabra.charAt(i);
        }

        char[] jugador = new char[this.palabra.length()];
        int ahorcado = 0;

        for(int i = 0; i < this.palabra.length(); ++i) {
            jugador[i] = '_';
        }

        do {
            boolean correct = false;
            this.dibujarAhorcado(ahorcado);

            int i;
            for(i = 0; i < this.palabra.length(); ++i) {
                System.out.print(jugador[i] + " ");
            }

            System.out.println("");
            char input = Jugador.turno();

            for(i = 0; i < this.palabra.length(); ++i) {
                if (input == palabraDiv[i]) {
                    jugador[i] = input;
                    correct = true;
                }
            }

            if (!correct) {
                ++ahorcado;
            }
        } while(!this.ganar(jugador, palabraDiv) && ahorcado != 7);

        if (this.ganar(jugador, palabraDiv)) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("OLEEEEEEEEEEE HAS ACERTADO LA PALABRA");
            System.out.println("------------------------------------------------------------------------------");
        } else {
            this.dibujarAhorcado(ahorcado);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("NOOOOOOOOOOOO. HAS PERDIDO :(");
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    public static void tutorial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                                A H O R C A D O");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("--------------------------------- EXPLICACIÓN --------------------------------");
        System.out.println("Deberás de adivinar una palabra en menos de 7 intentos. La mecánica es esta:\n");
        System.out.println("• El ordenador piensa una palabra y muestra de forma gráfica el número de letras");
        System.out.println("que tiene, por ejemplo un carácter “_” por cada una.\n");
        System.out.println("• Tú propones una letra.\n");
        System.out.println("• Si la letra está en la palabra se hará visible, pero si no está, se añadirá un");
        System.out.println("trazo al dibujo del ahorcado.\n");
        System.out.println("• Debes seguir proponiendo letras y el programa actuará en consecuencia");
        System.out.println("hasta que todos los caracteres de las palabras se hagan visibles ganando tú");
        System.out.println("o hasta que se complete el dibujo del ahorcado, que implicaría tu derrota.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Introduce un caracter para continuar: ");
        sc.next();
        System.out.println(" ");
    }

}