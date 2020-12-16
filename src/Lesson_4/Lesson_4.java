package Lesson_4;


import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
    public static final char NONEPLAY = '.';
    public static final char ONEPLAY = 'X';
    public static final char AIPLAY = '0';
    public static final int SIZE = 3;

    public static void main(String[] args) {
        start();
    }

    /*
     * 1. Полностью разобраться с кодом, попробовать переписать с нуля,
     *  стараясь не подглядывать в методичку.
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
     * например, с использованием циклов.
     * 3. * Попробовать переписать логику проверки победы,
     *  чтобы она работала для поля 5х5 и количества фишек * 4.
     * Очень желательно не делать это просто набором условий для
     *  каждой из возможных ситуаций;
     * 4. *** Доработать искусственный интеллект,
     * чтобы он мог блокировать ходы игрока.
     * * */
    // Запуск игры
    public static void start() {
        int freeItems = SIZE * SIZE;
        System.out.println("Игра началась!!!");
        char[][] Field = createField();
        printField(Field);
        while (true) {
            getPlayerTurn(Field);
            freeItems--;
            printField(Field);
            if (isWiner(Field, ONEPLAY)) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (freeItems == 0) {
                break;
            }
            getAiTurn(Field);
            freeItems--;
            printField(Field);
            if (isWiner(Field, AIPLAY)) {
                System.out.println("Извините, Вы проиграли!!!");
                break;
            }
            if (freeItems == 0) {
                break;
            }
        }
        System.out.println("Игра завершена.");
    }

    // Создание пустого игрового поля
    public static char[][] createField() {
        char[][] Field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Field[i][j] = NONEPLAY;
            }
        }
        return Field;
    }

    // Вывод поля на экран
    public static void printField(char[][] Field) {
        System.out.println();
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field.length; j++) {
                System.out.print("\t" + Field[i][j]);
            }
            System.out.println();
        }
    }

    // ход игрока
    public static void getPlayerTurn(char[][] Field) {
        int x, y;
        do {
            x = getCord('x');
            y = getCord('y');
        } while (Field[x][y] != NONEPLAY);
        Field[x][y] = ONEPLAY;
    }

    // ход компьютера
    public static void getAiTurn(char[][] Field) {
        int x = 0, y = 0;               // рабочие координаты
        int xDm = 0, yDm = 0;           // координаты свободного поля по главной диагонали
        int xDs = 0, yDs = 0;           // координаты свободного поля по побочной диагонали
        int countDm = 0, countDs = 0;   // кол-во симолов игрока га диоганалях
        int countMax = 0;               // максимальное кол-во симолов игрока

        for (int i = 0; i < SIZE; i++) {
            int xH = 0, yH = 0;     // координаты свободного поля по горизонтали
            int xV = 0, yV = 0;     // координаты свободного поля по вертикали
            int countH = 0, countV = 0;
            for (int j = 0; j < SIZE; j++) {
                // проверка горизонтали
                if (Field[i][j] == ONEPLAY) {
                    countH++;
                } else if (Field[i][j] == AIPLAY) {
                    countH--;
                } else {
                    xH = xH == 0 ? i : xH;
                    yH = yH == 0 ? j : yH;
                }
                // проверка по вертикали
                if (Field[j][i] == ONEPLAY) {
                    countV++;
                } else if (Field[j][i] == AIPLAY) {
                    countV--;
                } else {
                    xV = xV == 0 ? j : xV;
                    yV = yV == 0 ? i : yV;
                }
                // проверка главной диагонали
                if (i == j) {
                    if (Field[i][j] == ONEPLAY) {
                        countDm++;
                    } else if (Field[i][j] == AIPLAY) {
                        countDm--;
                    } else {
                        xDm = xDm == 0 ? i : xDm;
                        yDm = yDm == 0 ? j : yDm;
                    }
                }
                //проверка побочной диагонали
                if (j == SIZE - 1 - i) {
                    if (Field[i][j] == ONEPLAY) {
                        countDs++;
                    } else if (Field[i][j] == AIPLAY) {
                        countDs--;
                    } else {
                        xDs = xDs == 0 ? i : xDs;
                        yDs = yDs == 0 ? j : yDs;
                    }
                }
            }
            // Если больше по горизонтали/вертикали
            if ((countH > countV) && countH > countMax) {
                countMax = countH;
                x = xH;
                y = yH;
            } else if (countV > countMax) {
                countMax = countV;
                x = xV;
                y = yV;
            }
        }
        // если больше по диагонали
        if ((countDm > countDs) && countDm > countMax) {
            x = xDm;
            y = yDm;
        } else if (countDs > countMax) {
            x = xDs;
            y = yDs;
        }
//        Random rnd = new Random();
//        do {
//            x = rnd.nextInt(SIZE);
//            y = rnd.nextInt(SIZE);
//        } while (Field[x][y] != NONEPLAY);
        Field[x][y] = AIPLAY;
    }

    // получение и проверка координат от игрока
    private static int getCord(char Sing) {
        Scanner in = new Scanner(System.in);
        int cord;
        do {
            System.out.println(String.format("Введите %s-координту от 1...%d", Sing, SIZE));
            cord = in.nextInt() - 1;
        } while (cord < 0 || cord >= SIZE);
        return cord;
    }

    // проверка на выйгрыш
    private static boolean isWiner(char[][] Field, char Sign) {
        boolean winH, winV, winDm, winDs;
        winDm = winDs = true;
        for (int i = 0; i < Field.length; i++) {
            winH = winV = true;
            for (int j = 0; j < Field[i].length; j++) {
                // проверка горизонтальной
                if (Field[i][j] != Sign) {
                    winH = false;
                }
                // проверка вертикальной
                if (Field[j][i] != Sign) {
                    winV = false;
                }
                // проверка главной диагонали
                if (i == j) {
                    if (Field[i][j] != Sign) {
                        winDm = false;
                    }
                }
                //проверка побочной диагонали
                if (j == SIZE - 1 - i) {
                    if (Field[i][j] != Sign) {
                        winDs = false;
                    }
                }
            }
            if (winH || winV) {
                return true;
            }
        }
        if (winDm || winDs) {
            return true;
        }
        return false;
    }
}
