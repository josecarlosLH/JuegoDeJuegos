package juego.de.la.vida;

import java.util.Scanner;

public class Juego {
    int bichosVivos, alto, ancho;
    int[][] matrizAux;
    int[][] matriz;
    boolean generarAleatorio;

    public Juego() {
        this.matriz = new int[20][20];
        this.matrizAux = new int[20][20];
        this.generarAleatorio = true;
        this.bichosVivos = 0;
        this.alto = this.matriz.length;
        this.ancho = this.matriz[0].length;
        this.randomizar();
    }

    public Juego(int x, int y) {
        this.matriz = new int[x][y];
        this.matrizAux = new int[x][y];
        this.generarAleatorio = true;
        this.bichosVivos = 0;
        this.alto = this.matriz.length;
        this.ancho = this.matriz[0].length;
        this.randomizar();
    }

    public Juego(int x, int y, int bichosVivos) {
        this.matriz = new int[x][y];
        this.matrizAux = new int[x][y];
        this.generarAleatorio = false;
        this.bichosVivos = bichosVivos;
        this.alto = this.matriz.length;
        this.ancho = this.matriz[0].length;
        this.randomizar();
    }

    public Juego(int bichosVivos) {
        this.matriz = new int[20][20];
        this.matrizAux = new int[20][20];
        this.generarAleatorio = false;
        this.bichosVivos = bichosVivos;
        this.alto = this.matriz.length;
        this.ancho = this.matriz[0].length;
        this.randomizar();
    }

    public void imprimir() {
        for(int i = 0; i < this.alto; ++i) {
            int j;
            for(j = 0; j < this.ancho; ++j) {
                if (j == 0) {
                    System.out.print("+---+");
                } else {
                    System.out.print("---+");
                }
            }

            System.out.println("");

            for(j = 0; j < this.ancho; ++j) {
                System.out.print("| ");
                if (this.matriz[j][i] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }

                if (j == this.ancho - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("");
            if (i == this.alto - 1) {
                System.out.print("+---+");

                for(j = 1; j < this.ancho; ++j) {
                    System.out.print("---+");
                }
            }
        }

        System.out.println("");
    }

    void imprimirPosiciones() {
        for(int i = 0; i < this.alto; ++i) {
            int j;
            for(j = 0; j < this.ancho; ++j) {
                if (j == 0) {
                    System.out.print("+----+");
                } else {
                    System.out.print("----+");
                }
            }

            System.out.println("");

            for(j = 0; j < this.ancho; ++j) {
                System.out.print("| ");
                System.out.print(j);
                System.out.print(i);
                if (j == this.ancho - 1) {
                    System.out.print(" |");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("");
            if (i == this.alto - 1) {
                System.out.print("+----+");

                for(j = 1; j < this.ancho; ++j) {
                    System.out.print("----+");
                }
            }
        }

        System.out.println("");
    }

    final void randomizar() {
        int i;
        int j;
        for(i = 0; i < this.ancho; ++i) {
            for(j = 0; j < this.alto; ++j) {
                this.matriz[i][j] = 0;
            }
        }

        if (this.generarAleatorio) {
            for(i = 0; i < this.ancho; ++i) {
                for(j = 0; j < this.alto; ++j) {
                    if ((int)(Math.random() * 6.0D) == 0) {
                        this.matriz[i][j] = 1;
                    }
                }
            }
        } else {
            for(i = 0; i < this.bichosVivos; ++i) {
                this.matriz[(int)(Math.random() * (double)this.alto)][(int)(Math.random() * (double)this.ancho)] = 1;
            }
        }

    }

    int contarBichosCercanos(int x, int y) {
        int cont = 0;
        if (x > 0) {
            if (this.matrizAux[x - 1][y] == 1) {
                ++cont;
            }

            if (y > 0) {
                if (this.matrizAux[x - 1][y - 1] == 1) {
                    ++cont;
                }

                if (this.matrizAux[x][y - 1] == 1) {
                    ++cont;
                }
            }

            if (y < this.alto - 1) {
                if (this.matrizAux[x - 1][y + 1] == 1) {
                    ++cont;
                }

                if (this.matrizAux[x][y + 1] == 1) {
                    ++cont;
                }
            }
        }

        if (x < this.ancho - 1) {
            if (this.matrizAux[x + 1][y] == 1) {
                ++cont;
            }

            if (y > 0 && this.matrizAux[x + 1][y - 1] == 1) {
                ++cont;
            }

            if (y < this.alto - 1 && this.matrizAux[x + 1][y + 1] == 1) {
                ++cont;
            }
        }

        return cont;
    }

    void comprobarVivos(int x, int y) {
        if (this.contarBichosCercanos(x, y) == 3) {
            this.matriz[x][y] = 1;
        }

    }

    void comprobarMuertos(int x, int y) {
        if (this.contarBichosCercanos(x, y) != 2 && this.contarBichosCercanos(x, y) != 3) {
            this.matriz[x][y] = 0;
        }

    }

    void realizarCiclo() {
        int i;
        int j;
        for(i = 0; i < this.ancho; ++i) {
            for(j = 0; j < this.alto; ++j) {
                this.matrizAux[i][j] = this.matriz[i][j];
            }
        }

        for(i = 0; i < this.ancho; ++i) {
            for(j = 0; j < this.alto; ++j) {
                if (this.matrizAux[i][j] == 0) {
                    this.comprobarVivos(i, j);
                }

                if (this.matrizAux[i][j] == 1) {
                    this.comprobarMuertos(i, j);
                }
            }
        }

    }

    public void simular(int generaciones) {
        for(int i = 0; i < generaciones; ++i) {
            this.realizarCiclo();
        }

    }

    static void tutorial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                        J U E G O   D E   L A   V I D A");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("--------------------------------- EXPLICACIÓN --------------------------------");
        System.out.println("Este juego simula la evolución de una colonia de bichos que vive en un mundo");
        System.out.println("cuadriculado cuyas casillas, en un momento dado, pueden estar vacías o habitadas");
        System.out.println("por un único ser. La evolución de la población de un instante a otro se rige por");
        System.out.println("las siguientes reglas:");
        System.out.println("------------------------------- REGLAS DE JUEGO ------------------------------");
        System.out.println("• Generación inicial: Se genera de forma aleatoria.");
        System.out.println("\n• Nacimiento: En una casilla vacía que tenga exactamente 3 casillas vecinas");
        System.out.println("habitadas, nace un nuevo bicho. Consideramos vecinas a las ocho casillas ");
        System.out.println("circundantes a una dada");
        System.out.println("\n• Supervivencia: Cada bicho que tenga dos o tres bichos vecinos sobrevive y");
        System.out.println("pasa a la generación siguiente.");
        System.out.println("\n• Muerte: Cada bicho que sólo tenga un bicho vecino o no tenga ninguno, muere de");
        System.out.println("soledad. Cada bicho con cuatro bichos vecinos o más, muere por superpoblación.");
        System.out.println("\n• Todos los nacimientos o muertes ocurren simultáneamente.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Introduce un caracter para continuar: ");
        sc.next();
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Juego sim = new Juego();
        sim.randomizar();

        for(int i = 0; i < 10; ++i) {
            sim.imprimir();
            System.out.println(sim.contarBichosCercanos(1, 1));
            sim.realizarCiclo();
        }

    }
}
