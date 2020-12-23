package Lesson_6;

abstract public class Animals {
    private static int count = 0;
    private String name;
    private int maxRun;
    private int maxSwim;

    public Animals(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        count++;
    }

    public void goRun(int len) {
        if (len > maxRun) {
            System.out.printf("Дистанция %d м.> %d м. возможости %s.%n", len, maxRun, name);
        } else {
            System.out.printf("%s  пробежал %d м.%n", name, len);
        }
    }

    public void goSwim(int len) {
        if (maxSwim == 0) {
            System.out.printf("%s не умеет плавать.%n", name);
        } else if (len > maxSwim) {
            System.out.printf("Дистанция %d м.> %d м. возможости %s.%n", len, maxSwim, name);
        } else {
            System.out.printf("%s  проплыл %d м.%n", name, len);
        }
    }

    public static void infoCount() {
        System.out.println("Количество животных: " + count);
    }
}
