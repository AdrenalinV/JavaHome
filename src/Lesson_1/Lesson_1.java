package Lesson_1;

public class Lesson_1 {
    public static void main(String[] args) {
        byte b1 = 125;
        short s1 = 769;
        int i1 = 32987;
        long l1 = 123344667;
        float f2 = 12.345f;
        double d2 = 1234.123457890;
        char c1 = 'V';
        boolean b2 = true;
        System.out.println("byte: " + b1);
        System.out.println("short: " + s1);
        System.out.println("int: " + i1);
        System.out.println("long: " + l1);
        System.out.println("float: " + f2);
        System.out.println("double: " + d2);
        System.out.println("char: " + c1);
        System.out.println("boolean: " + b2);
        System.out.println();
        System.out.println("Arifmometr 5*(2+(10/3)): " + Arifmometr(5, 2, 10, 3));
        System.out.println("Interval 10+5: " + Interval(10, 5));
        System.out.println("Interval 1+5: " + Interval(1, 5));
        CheckSign(-5);
        CheckSign(10);
        System.out.println("-5 отрицательное число? " + CheckSignB(-5));
        System.out.println("5 отрицательное число? " + CheckSignB(5));
        Hello("Vadim");
        Vyear(2000);
        Vyear(2100);
        Vyear(1992);
    }

    static float Arifmometr(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    static boolean Interval(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    static void CheckSign(int a) {
        if (a < 0) {
            System.out.println(a + " - отрицательное число.");
        } else System.out.println(a + " - положительное число.");
    }

    static boolean CheckSignB(long a) {
        return a < 0;
    }

    static void Hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    static void Vyear(int y) {
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
            System.out.println("Високосный год - " + y);
        } else {
            System.out.println("обычный год - " + y);
        }
    }
}
