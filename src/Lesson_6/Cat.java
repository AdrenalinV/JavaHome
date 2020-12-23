package Lesson_6;

public class Cat extends Animals {
    private static int count = 0;
    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 0;

    public Cat(String name) {
        super(name, MAX_RUN, MAX_SWIM);
        count++;
    }

    public static void infoCount() {
        System.out.println("Количество котов: " + count);
    }
}
