package Lesson_6;

public class Dog extends Animals {
    private static int count = 0;
    private static final int MAX_RUN = 500;
    private static final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name, MAX_RUN, MAX_SWIM);
        count++;
    }

    public static void infoCount() {
        System.out.println("Количество собак: " + count);
    }
}

