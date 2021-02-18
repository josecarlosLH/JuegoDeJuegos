package tres.en.raya.en.mov;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Jugador {
    int jugador;

    public Jugador(int numJug) {
        this.jugador = numJug;
    }

    public void turnoClasico(int[][] tablero) {
        boolean entradaValida = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\nES EL TURNO DE: ");
            if (this.jugador == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

            System.out.print("\nELIGE UNA CASILLA: ");
            String posicion = sc.next().toUpperCase();
            System.out.println("");
            if (Pattern.matches("[A-C][1-3]", posicion)) {
                if (tablero[Juego.selecCasillaEjeY(posicion)][Juego.selecCasillaX(posicion)] == 0) {
                    tablero[Juego.selecCasillaEjeY(posicion)][Juego.selecCasillaX(posicion)] = this.jugador;
                    entradaValida = true;
                } else {
                    System.out.println("Ya hay una ficha en esta casilla.");
                }
            } else {
                System.out.println("La ficha no se puede colocar ahí porque está fuera del tablero :(\n¡Prueba de nuevo!");
            }
        } while(!entradaValida);

    }

    public void turnoMoviendo(int[][] board) {
        boolean entradaValida = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\nES EL TURNO DE: ");
            if (this.jugador == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

            System.out.print("\nELIGE LA FICHA QUE QUIERAS MOVER: ");
            String position = sc.next().toUpperCase();
            System.out.println("");
            if (!Pattern.matches("[A-C][1-3]", position)) {
                System.out.println("Has elegido una ficha que no está dentro del tablero D:");
            } else if (board[Juego.selecCasillaEjeY(position)][Juego.selecCasillaX(position)] != this.jugador) {
                System.out.println("No hay una ficha tuya en esta casilla.");
            } else {
                boolean rodeado = true;
                int y = Juego.selecCasillaEjeY(position);
                int x = Juego.selecCasillaX(position);
                if (y < 2 && board[y + 1][x] == 0) {
                    rodeado = false;
                }

                if (y > 0 && board[y - 1][x] == 0) {
                    rodeado = false;
                }

                if (x < 2 && board[y][x + 1] == 0) {
                    rodeado = false;
                }

                if (x > 0 && board[y][x - 1] == 0) {
                    rodeado = false;
                }

                if (rodeado) {
                    System.out.println("Esta ficha no se puede mover.");
                } else {
                    System.out.println("¿Hacia qué dirección quieres mover tu ficha? (W / A / S / D)");
                    char direccion = sc.next().toUpperCase().charAt(0);

                    do {
                        if (direccion != 'W' && direccion != 'A' && direccion != 'S' && direccion != 'D') {
                            System.out.println("No es correcta la entrada.\n[W] Arriba\n[A] Izquierda\n[S] Abajo [D] Derecha");
                        } else {
                            switch(direccion) {
                                case 'A':
                                    if (x > 0) {
                                        board[y][x] = 0;
                                        board[y][x - 1] = this.jugador;
                                        entradaValida = true;
                                    }
                                    break;
                                case 'D':
                                    if (x < 2) {
                                        board[y][x] = 0;
                                        board[y][x + 1] = this.jugador;
                                        entradaValida = true;
                                    }
                                    break;
                                case 'S':
                                    if (y < 2) {
                                        board[y][x] = 0;
                                        board[y + 1][x] = this.jugador;
                                        entradaValida = true;
                                    }
                                    break;
                                case 'W':
                                    if (y > 0) {
                                        board[y][x] = 0;
                                        board[y - 1][x] = this.jugador;
                                        entradaValida = true;
                                    }
                            }
                        }
                    } while(!entradaValida);
                }
            }
        } while(!entradaValida);

    }

    public void turnoMovRandom(int[][] tablero) {
        int cuantosRegistros = 0;
        int direccion;
        int contRegistros = 0;
        int x = 0;
        int y = 0;
        boolean valido = false;
        boolean esta = true;

        int i;
        int j;
        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 3; ++j) {
                if (tablero[i][j] == 2) {
                    ++cuantosRegistros;
                }
            }
        }

        int numRegistros = (int)(Math.random() * (double)cuantosRegistros);

        do {
            for(i = 0; i < 3; ++i) {
                for(j = 0; j < 3; ++j) {
                    if (contRegistros == numRegistros) {
                        x = i;
                        y = j;
                    }

                    if (tablero[i][j] == 2) {
                        ++contRegistros;
                    }
                }
            }

            if (y < 2 && tablero[y + 1][x] == 0) {
                esta = false;
            }

            if (y > 0 && tablero[y - 1][x] == 0) {
                esta = false;
            }

            if (x < 2 && tablero[y][x + 1] == 0) {
                esta = false;
            }

            if (x > 0 && tablero[y][x - 1] == 0) {
                esta = false;
            }
        } while(esta);

        do {
            direccion = (int) (Math.random() * 4.0D);
            if (y < 1 && direccion == 1) {
                direccion = 4;
            }

            if (x < 1 && direccion == 3) {
                direccion = 2;
            }

            if (y > 1 && direccion == 4) {
                direccion = 1;
            }

            if (x > 1 && direccion == 2) {
                direccion = 3;
            }

            tablero[y][x] = 0;
            switch(direccion) {
                case 1:
                    if (tablero[y - 1][x] == 0) {
                        tablero[y - 1][x] = 2;
                        valido = true;
                    }
                    break;
                case 2:
                    if (tablero[y][x + 1] == 0) {
                        tablero[y][x + 1] = 2;
                        valido = true;
                    }
                    break;
                case 3:
                    if (tablero[y][x - 1] == 0) {
                        tablero[y][x - 1] = 2;
                        valido = true;
                    }
                    break;
                case 4:
                    if (tablero[y + 1][x] == 0) {
                        tablero[y + 1][x] = 2;
                        valido = true;
                    }
            }
        } while(!valido);

        tablero[y][x] = 0;
    }
}