package tres.en.raya.clasico;

public class Tablero {
    int[][] tablero = new int[3][3];

    public void imprimirTablero() {
        System.out.println("     1     2     3  ");
        System.out.println("");
        System.out.println("        |     |     ");
        System.out.print("A    ");

        int i;
        for(i = 0; i < 3; ++i) {
            switch(this.tablero[0][i]) {
                case 0:
                    System.out.print(" ");
                    break;
                case 1:
                    System.out.print("X");
                    break;
                case 2:
                    System.out.print("O");
            }

            if (i < 2) {
                System.out.print("  |  ");
            }
        }

        System.out.println("\n        |     |     ");
        System.out.println("   -----------------");
        System.out.println("        |     |     ");
        System.out.print("B    ");

        for(i = 0; i < 3; ++i) {
            switch(this.tablero[1][i]) {
                case 0:
                    System.out.print(" ");
                    break;
                case 1:
                    System.out.print("X");
                    break;
                case 2:
                    System.out.print("O");
            }

            if (i < 2) {
                System.out.print("  |  ");
            }
        }

        System.out.println("\n        |     |     ");
        System.out.println("   -----------------");
        System.out.println("        |     |     ");
        System.out.print("C    ");

        for(i = 0; i < 3; ++i) {
            switch(this.tablero[2][i]) {
                case 0:
                    System.out.print(" ");
                    break;
                case 1:
                    System.out.print("X");
                    break;
                case 2:
                    System.out.print("O");
            }

            if (i < 2) {
                System.out.print("  |  ");
            }
        }

        System.out.println("\n        |     |     ");
    }

    public int ganador() {
        int ganador = 0;
        boolean completo = true;

        int i;
        for(i = 0; i < 3; ++i) {
            if (this.tablero[0][i] == 1) {
                if (this.tablero[1][i] == 1 && this.tablero[2][i] == 1) {
                    ganador = 1;
                }

                switch(i) {
                    case 0:
                        if (this.tablero[1][1] == 1 && this.tablero[2][2] == 1) {
                            ganador = 1;
                        }
                        break;
                    case 2:
                        if (this.tablero[1][1] == 1 && this.tablero[2][0] == 1) {
                            ganador = 1;
                        }
                }
            }
        }

        for(i = 0; i < 3; ++i) {
            if (this.tablero[0][i] == 2) {
                if (this.tablero[1][i] == 2 && this.tablero[2][i] == 2) {
                    ganador = 2;
                }

                switch(i) {
                    case 0:
                        if (this.tablero[1][1] == 2 && this.tablero[2][2] == 2) {
                            ganador = 2;
                        }
                        break;
                    case 2:
                        if (this.tablero[1][1] == 2 && this.tablero[2][0] == 2) {
                            ganador = 2;
                        }
                }
            }
        }

        for(i = 0; i < 3; ++i) {
            if (this.tablero[i][0] == 1 && this.tablero[i][1] == 1 && this.tablero[i][2] == 1) {
                ganador = 1;
            }

            if (this.tablero[i][0] == 2 && this.tablero[i][1] == 2 && this.tablero[i][2] == 2) {
                ganador = 2;
            }
        }

        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (this.tablero[i][j] == 0) {
                    completo = false;
                }
            }
        }

        if (completo) {
            ganador = 3;
        }

        return ganador;
    }

    public int aPuntoDeGanar() {
        int casos = 20;
        if (this.tablero[0][0] == 1) {
            if (this.tablero[0][1] == 1 && this.tablero[0][2] == 0) {
                casos = 0;
            }

            if (this.tablero[0][1] == 0 && this.tablero[0][2] == 1) {
                casos = 1;
            }

            if (this.tablero[1][1] == 1 && this.tablero[2][2] == 0) {
                casos = 2;
            }

            if (this.tablero[1][1] == 0 && this.tablero[2][2] == 1) {
                casos = 3;
            }

            if (this.tablero[1][0] == 1 && this.tablero[2][0] == 0) {
                casos = 4;
            }

            if (this.tablero[1][0] == 0 && this.tablero[2][0] == 1) {
                casos = 5;
            }
        }

        if (this.tablero[0][2] == 1) {
            if (this.tablero[0][0] == 0 && this.tablero[0][1] == 1) {
                casos = 6;
            }

            if (this.tablero[2][2] == 1 && this.tablero[2][0] == 0) {
                casos = 7;
            }

            if (this.tablero[1][1] == 0 && this.tablero[2][0] == 1) {
                casos = 8;
            }

            if (this.tablero[1][2] == 1 && this.tablero[2][2] == 0) {
                casos = 9;
            }

            if (this.tablero[1][2] == 0 && this.tablero[2][2] == 1) {
                casos = 10;
            }
        }

        if (this.tablero[0][1] == 1 && this.tablero[1][1] == 1 && this.tablero[2][1] == 0) {
            casos = 11;
        }

        if (this.tablero[0][1] == 1 && this.tablero[1][1] == 0 && this.tablero[2][1] == 1) {
            casos = 12;
        }

        if (this.tablero[0][1] == 0 && this.tablero[1][1] == 1 && this.tablero[2][1] == 1) {
            casos = 13;
        }

        if (this.tablero[1][0] == 1 && this.tablero[1][1] == 1 && this.tablero[1][2] == 0) {
            casos = 14;
        }

        if (this.tablero[1][0] == 1 && this.tablero[1][1] == 0 && this.tablero[1][2] == 1) {
            casos = 15;
        }

        if (this.tablero[1][0] == 0 && this.tablero[1][1] == 1 && this.tablero[1][2] == 1) {
            casos = 16;
        }

        if (this.tablero[2][0] == 1 && this.tablero[2][1] == 1 && this.tablero[2][2] == 0) {
            casos = 17;
        }

        if (this.tablero[2][0] == 1 && this.tablero[2][1] == 0 && this.tablero[2][2] == 1) {
            casos = 18;
        }

        if (this.tablero[2][0] == 0 && this.tablero[2][1] == 1 && this.tablero[2][2] == 1) {
            casos = 19;
        }

        return casos;
    }
}