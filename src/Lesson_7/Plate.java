package Lesson_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void info(){
        System.out.println("plate: "+ this.food);
    }

    public boolean decreaseFood(int n){
        if (n>this.food) {
            return false;
        }
        this.food-=n;
        return true;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
