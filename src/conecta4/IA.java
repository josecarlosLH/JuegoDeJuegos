package conecta4;

public class IA {
    static String aPuntoDeGanar(int[][] matriz) {
        StringBuilder retornar = new StringBuilder("FX1");

        int i;
        int j;
        for(i = 0; i < 4; ++i) {
            for(j = 0; j < 6; ++j) {
                if (matriz[i][j] == 1 && matriz[i + 1][j] == 1 && matriz[i + 2][j] == 1 && matriz[i + 3][j] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i + 3 + 48 + 1));
                    return retornar.toString();
                }

                if (matriz[i][j] == 2 && matriz[i + 1][j] == 2 && matriz[i + 2][j] == 2 && matriz[i + 3][j] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'O');
                    retornar.setCharAt(2, (char)(i + 3 + 48 + 1));
                    return retornar.toString();
                }
            }
        }

        for(i = 6; i > 2; --i) {
            for(j = 0; j < 6; ++j) {
                if (matriz[i][j] == 1 && matriz[i - 1][j] == 1 && matriz[i - 2][j] == 1 && matriz[i - 3][j] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i - 3 + 48 + 1));
                    return retornar.toString();
                }

                if (matriz[i][j] == 2 && matriz[i - 1][j] == 2 && matriz[i - 2][j] == 2 && matriz[i - 3][j] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'O');
                    retornar.setCharAt(2, (char)(i - 3 + 48 + 1));
                    return retornar.toString();
                }
            }
        }

        for(i = 0; i < 7; ++i) {
            for(j = 3; j < 6; ++j) {
                if (matriz[i][j] == 1 && matriz[i][j - 1] == 1 && matriz[i][j - 2] == 1 && matriz[i][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i + 48 + 1));
                    return retornar.toString();
                }

                if (matriz[i][j] == 2 && matriz[i][j - 1] == 2 && matriz[i][j - 2] == 2 && matriz[i][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'O');
                    retornar.setCharAt(2, (char)(i + 48 + 1));
                    return retornar.toString();
                }
            }
        }

        for(i = 0; i < 4; ++i) {
            for(j = 3; j < 6; ++j) {
                if (matriz[i][j] == 1 && matriz[i + 1][j - 1] == 1 && matriz[i + 2][j - 2] == 1 && matriz[i + 3][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i + 3 + 48 + 1));
                    return retornar.toString();
                }

                if (matriz[i][j] == 2 && matriz[i + 1][j - 1] == 2 && matriz[i + 2][j - 2] == 2 && matriz[i + 3][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i + 3 + 48 + 1));
                    return retornar.toString();
                }
            }
        }

        for(i = 3; i < 7; ++i) {
            for(j = 3; j < 6; ++j) {
                if (matriz[i][j] == 1 && matriz[i - 1][j - 1] == 1 && matriz[i - 2][j - 2] == 1 && matriz[i - 3][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i - 3 + 48 + 1));
                    return retornar.toString();
                }

                if (matriz[i][j] == 2 && matriz[i - 1][j - 1] == 2 && matriz[i - 2][j - 2] == 2 && matriz[i - 3][j - 3] == 0) {
                    retornar.setCharAt(0, 'T');
                    retornar.setCharAt(1, 'X');
                    retornar.setCharAt(2, (char)(i - 3 + 48 + 1));
                    return retornar.toString();
                }
            }
        }
        return retornar.toString();
    }
}
