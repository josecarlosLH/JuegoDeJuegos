package luces.fuera;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Tablero {
    int[][] matriz;
    int[][] orden;
    int[][] matrizGuardada;

    public Tablero() {
        this.matriz = new int[5][5];
        this.orden = new int[5][5];
        this.matrizGuardada = new int[5][5];
    }

    void print() {
        int caract = 65;
        System.out.println("  1     2     3     4      5");
        for (int j = 0; j < 5; ++j) {
            System.out.println("     |     |     |     |");
            for (int i = 0; i < 5; ++i) {
                System.out.print("  ");
                if (this.matriz[i][j] == 0) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("X");
                }
                if (i < 4) {
                    System.out.print("  |");
                }
            }
            System.out.print("      " + (char)caract);
            System.out.println("\n     |     |     |     |");
            if (j < 4) {
                System.out.println("-----+-----+-----+-----+-----");
            }
            ++caract;
        }
    }

    void click(final int x, final int y) {
        if (this.matriz[x][y] == 0) {
            this.matriz[x][y] = 1;
        }
        else {
            this.matriz[x][y] = 0;
        }
        if (y > 0) {
            if (this.matriz[x][y - 1] == 0) {
                this.matriz[x][y - 1] = 1;
            }
            else {
                this.matriz[x][y - 1] = 0;
            }
        }
        if (y < 4) {
            if (this.matriz[x][y + 1] == 0) {
                this.matriz[x][y + 1] = 1;
            }
            else {
                this.matriz[x][y + 1] = 0;
            }
        }
        if (x > 0) {
            if (this.matriz[x - 1][y] == 0) {
                this.matriz[x - 1][y] = 1;
            }
            else {
                this.matriz[x - 1][y] = 0;
            }
        }
        if (x < 4) {
            if (this.matriz[x + 1][y] == 0) {
                this.matriz[x + 1][y] = 1;
            }
            else {
                this.matriz[x + 1][y] = 0;
            }
        }
    }

    void randomizar() {
        final boolean[][] modificado = new boolean[5][5];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                this.orden[i][j] = 0;
            }
        }
        for (int i = 1; i < 11; ++i) {
            final int x = (int)(Math.random() * 5.0);
            final int y = (int)(Math.random() * 5.0);
            if (!modificado[x][y]) {
                this.click(x, y);
                modificado[x][y] = true;
                this.orden[x][y] = i;
            }
            else {
                --i;
            }
        }
    }

    boolean solucionado() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (this.matriz[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    void guardar() {
        for (int i = 0; i < this.matriz.length; ++i) {
            for (int j = 0; j < this.matriz[i].length; ++j) {
                this.matriz[i][j] = this.matrizGuardada[i][j];
            }
        }
    }

    void cargar() {
        for (int i = 0; i < this.matrizGuardada.length; ++i) {
            for (int j = 0; j < this.matrizGuardada[i].length; ++j) {
                this.matrizGuardada[i][j] = this.matriz[i][j];
            }
        }
    }

    int[] cargar(final int num) {
        final int[] coordinates = new int[2];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (this.orden[i][j] == num) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }

    void resolucion() {
        this.cargar();
        int movimientos = 0;
        final Scanner in = new Scanner(System.in);
        String entrada;
        do {
            System.out.println("Movimiento: " + movimientos + "\n");
            this.print();
            System.out.println("[A] Avanzar");
            System.out.println("[R] Retroceder");
            System.out.println("[S] Salir");
            do {
                entrada = in.next().toUpperCase();
                if (!Pattern.matches("[ARS]", entrada)) {
                    System.out.println("Entrada incorrecta.");
                }
            } while (!Pattern.matches("[ARS]", entrada));
            switch (entrada.charAt(0)) {
                case 'A': {
                    if (!this.solucionado()) {
                        ++movimientos;
                        this.click(this.cargar(movimientos)[0], this.cargar(movimientos)[1]);
                        continue;
                    }
                    System.out.println("¡EL PUZZLE YA ESTÁ RESUELTO!.");
                    continue;
                }
                case 'R': {
                    if (movimientos > 0) {
                        this.click(this.cargar(movimientos)[0], this.cargar(movimientos)[1]);
                        --movimientos;
                        continue;
                    }
                    System.out.println("No puedes retroceder.");
                    continue;
                }
                case 'S': {}
                default: {
                    continue;
                }
            }
        } while (entrada.charAt(0) != 'S');
    }
}