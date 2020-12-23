package Lesson_6;

public class Lesson_6 {
    public static void main(String[] args) {
    /*
        1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому
        методу передается длина препятствия. Результатом выполнения действия
        будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        плавание: кот не умеет плавать, собака 10 м.).
        4. * Добавить подсчет созданных котов, собак и животных.
     */
        Animals[] pets=new Animals[]{
                new Cat("Barsik"),
                new Dog("Sharik"),
                new Dog("Bobik"),
                new Cat("Sema"),
                new Dog("Rex")
        };
        for (int i = 0; i <pets.length ; i++) {
            pets[i].goRun((100*i));
            pets[i].goSwim((5* i));
        }
        ((Cat)pets[0]).infoCount();
        ((Dog)pets[1]).infoCount();
        pets[0].infoCount();
    }
}
