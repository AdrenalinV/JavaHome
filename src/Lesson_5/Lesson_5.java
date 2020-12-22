package Lesson_5;

public class Lesson_5 {
    public static void main(String[] args) {
        Person[] persArray =new Person[5];
        persArray[0]=new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, (byte) 30);
        persArray[1]=new Person("Petrov Petr", "TeamLead", "petrov@mailbox.com", "892345676", 50000, (byte) 42);
        persArray[2]=new Person("Sidorov Boris", "Programmer", "sidorov@mailbox.com", "89685437658", 35000, (byte) 35);
        persArray[3]=new Person("Zembershtein Akakii", "Testr", "zembershtein@mailbox.com", "89100101010", 60000, (byte) 50);
        persArray[4]=new Person("Puzdoi Travalabnor", "Programmer", "puzdoi@mailbox.com", "89020020202", 40000, (byte) 41);

        for (Person pers: persArray) {
            if (pers.getAge()>40){
                pers.printPerson();
                System.out.println();
            }
        }
    }
    /*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    * 2. Конструктор класса должен заполнять эти поля при создании объекта.
    * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    * 4. Создать массив из 5 сотрудников.
    * Пример:
    * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
    * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
    * persArray[1] = new Person(...);
    * ...
    * persArray[4] = new Person(...);

    * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/
}
