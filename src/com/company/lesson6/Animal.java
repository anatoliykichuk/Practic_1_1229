package com.company.lesson6;

public abstract class Animal {

    public static int id;

    String name;
    String kind;
    String sex;
    int age;

    int acumulatedRunDistance;
    int acumulatedSwimDistance;

    public Animal(String name, String kind, String sex, int age) {
        this.name = name;
        this.kind = kind;
        this.sex = sex;

        setAge(age);
    }

    public Animal(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0 || age < 30) {
            this.age = age;
        } else {
            System.out.println("Возраст должен быть реальным!");
        }
    }

    public abstract void run(int distance);

    public void swim(int distance, int maxDistance) {
        acumulatedSwimDistance += distance;
        int restOfDistance = acumulatedSwimDistance - maxDistance;

        if (restOfDistance >= distance) {
            System.out.printf("%s поплыл %d м...", name, distance);

        } else if (restOfDistance > 0) {
            System.out.printf("%s поплыл %d из %d м., так как устал...", name, restOfDistance, distance);

        } else {
            System.out.printf("%s устал и уже не в силах плыть, так как проплыл %d м...",
                    name, restOfDistance, distance);
        }
    }

}
