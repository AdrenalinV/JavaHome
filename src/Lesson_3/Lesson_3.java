package Lesson_3;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu=0;
        System.out.println("В какую игру будем играть?");
        System.out.println("1 - угадай число / 2 - угадай слово ");
        menu=in.nextInt();
        switch (menu){
            case 1:{
                lessonItem_1();
                break;
            } case 2: {
                lessonItem_2();
                break;
            } default:{
                System.out.println("До новых встреч!");
            }
        }



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
            play = in.nextInt();
        }

    }

    /*
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
     * "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
     * правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = "apple";
     * char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы.
     *  */
    public static void lessonItem_2() {
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String riddle_word, answer;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        char[] visible =new char[]{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        riddle_word = words[rnd.nextInt(words.length)];
        while (true) {
            System.out.print("Слово загадано: ");
            prinArray(visible);
            System.out.println("Введите ваш ответ: ");
            answer = in.next();
            if (answer.equals(riddle_word)) {
                System.out.println("Ура!!! Победа.");
                break;
            } else {
                visible = compareWord(riddle_word, answer);
            }
        }
    }

    private static char[] compareWord(String w1, String w2) {
        char[] res=new char[]{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        for (int i = 0; i <w1.length() && i<w2.length() ; i++) {
            if(w1.charAt(i)==w2.charAt(i)){
                res[i]=w1.charAt(i);
            }
        }
        return res;
    }
    private static void prinArray(char[] p){
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
        System.out.println();
    }
}
