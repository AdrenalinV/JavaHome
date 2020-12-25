package Lesson_7;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p){
        p.decreaseFood(this.appetite);
    };

    public int getAppetite() {
        return appetite;
    }
}
