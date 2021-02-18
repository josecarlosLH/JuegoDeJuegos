package conecta4;

class Tablero {
    int[][] tablero = new int[7][6];

    void imprimirTablero() {
        System.out.println("  1   2   3   4   5   6   7");

        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 7; ++j) {
                if (j > 0) {
                    System.out.print(" | ");
                } else {
                    System.out.print("| ");
                }

                switch(this.tablero[j][i]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("O");
                }
            }
            System.out.println(" |");
        }
        System.out.println("=============================");
    }

    boolean colocarX(int x) {
        boolean correcto = false;
        int y = 5;
        --x;

        while(!correcto && y >= 0) {
            if (this.tablero[x][y] == 0) {
                this.tablero[x][y] = 1;
                correcto = true;
            } else {
                --y;
            }
        }
        return correcto;
    }

    boolean colocarO(int x) {
        boolean correcto = false;
        int y = 5;
        --x;

        while(!correcto && y >= 0) {
            if (this.tablero[x][y] == 0) {
                this.tablero[x][y] = 2;
                correcto = true;
            } else {
                --y;
            }
        }
        return correcto;
    }

    int ganador() {
        int i, j;

        for(j = 0; j < 6; ++j) {
            for(i = 0; i < 4; ++i) {
                if (this.tablero[i][j] == 1 && this.tablero[i + 1][j] == 1 && this.tablero[i + 2][j] == 1 && this.tablero[i + 3][j] == 1) {
                    return 1;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 0; i < 4; ++i) {
                if (this.tablero[i][j] == 1 && this.tablero[i + 1][j + 1] == 1 && this.tablero[i + 2][j + 2] == 1 && this.tablero[i + 3][j + 3] == 1) {
                    return 1;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 6; i > 2; --i) {
                if (this.tablero[i][j] == 1 && this.tablero[i - 1][j + 1] == 1 && this.tablero[i - 2][j + 2] == 1 && this.tablero[i - 3][j + 3] == 1) {
                    return 1;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 0; i < 6; ++i) {
                if (this.tablero[i][j] == 1 && this.tablero[i][j + 1] == 1 && this.tablero[i][j + 2] == 1 && this.tablero[i][j + 3] == 1) {
                    return 1;
                }
            }
        }

        for(j = 0; j < 6; ++j) {
            for(i = 0; i < 4; ++i) {
                if (this.tablero[i][j] == 2 && this.tablero[i + 1][j] == 2 && this.tablero[i + 2][j] == 2 && this.tablero[i + 3][j] == 2) {
                    return 2;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 0; i < 4; ++i) {
                if (this.tablero[i][j] == 2 && this.tablero[i + 1][j + 1] == 2 && this.tablero[i + 2][j + 2] == 2 && this.tablero[i + 3][j + 3] == 2) {
                    return 2;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 6; i > 2; --i) {
                if (this.tablero[i][j] == 2 && this.tablero[i - 1][j + 1] == 2 && this.tablero[i - 2][j + 2] == 2 && this.tablero[i - 3][j + 3] == 2) {
                    return 2;
                }
            }
        }

        for(j = 0; j < 3; ++j) {
            for(i = 0; i < 6; ++i) {
                if (this.tablero[i][j] == 2 && this.tablero[i][j + 1] == 2 && this.tablero[i][j + 2] == 2 && this.tablero[i][j + 3] == 2) {
                    return 2;
                }
            }
        }

        boolean dibujar = true;

        for(i = 0; i < 6; ++i) {
            if (this.tablero[i][0] == 0) {
                dibujar = false;
            }
        }

        if (dibujar) {
            return 3;
        } else {
            return 0;
        }
    }
}