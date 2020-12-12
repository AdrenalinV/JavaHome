package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {
        lessonItem_1();

    }

    /*
     * 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
     *  После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    public static void lessonItem_1() {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int play = 1;
        while (play == 1) {
            int riddle = rnd.nextInt(10);
            int i = 0;
            for (; i < 3; i++) {
                System.out.println("Осталось попыток: " + (3 - i));
                System.out.println("Введите число от 0 до 9:");
                int answer = in.nextInt();
                if (answer == riddle) {
                    System.out.println("Ура победа");
                    break;
                } else if (answer < riddle) {
                    System.out.println("Загаданное число больше");
                } else {
                    System.out.println("Загаданное число меньше");
                }
            }
            if (i == 3) {
                System.out.println("Вы проиграли!\nЗагаданное число: " + riddle);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            play=in.nextInt();
        }

    }
}
