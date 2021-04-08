package com.company.lesson6;

public class Main {

    public static void main() {

        Dog bobic = new Dog("Бобик");

        bobic.run(250);
        bobic.run(200);
        bobic.run(100);
        bobic.run(100);

        bobic.swim(3);
        bobic.swim(4);
        bobic.swim(5);
        bobic.swim(8);

        Dog tuzik = new Dog("Тузик");
        tuzik.run(550);
        tuzik.swim(12);

        Cat monya = new Cat("Моня");
        monya.run(25);
        monya.run(150);
        monya.run(50);
        monya.run(10);

        System.out.printf("Всего живтоных: %d", Animal.id);
    }

}
