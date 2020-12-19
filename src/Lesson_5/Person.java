package Lesson_5;

public class Person {
    private String name;       //ФИО
    private String position;   // должность
    private String email;      // email
    private String phone;          // телефон
    private double salary;      // зарплата
    private byte age;           // возраст

    // конструктор с параметрами
    public Person(String name, String position, String email, String phone, double salary, byte age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // Вывад в консоль
    public void printPerson() {
        System.out.println("Name:\t" + this.name);
        System.out.println("Position:\t" + this.position);
        System.out.println("email:\t" + this.email);
        System.out.println("Phone:\t" + this.phone);
        System.out.println("Salary:\t" + this.salary);
        System.out.println("Age:\t" + this.age);
    }

    public byte getAge() {
        return age;
    }
}
