package com.company.lesson6;

public abstract class Animal {

    public static int id;

    public String name;
    public String kind;
    public String sex;
    public int age;

    public int acumulatedRunDistance;
    public int acumulatedSwimDistance;

    public Animal(String name) {
        id++;
        this.name = name;
    }

    public Animal(String name, String kind, String sex, int age) {
        id++;

        this.name = name;
        this.kind = kind;
        this.sex = sex;

        setAge(age);
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
        int acumulatedSwimDistanceBefore = acumulatedSwimDistance;
        acumulatedSwimDistance += distance;
        int restSwimDistance = maxDistance - acumulatedSwimDistance;

        if (maxDistance >= acumulatedSwimDistance && acumulatedSwimDistance == distance) {
            System.out.printf("%s поплыл %d м...\n", name, distance);

        } else if (maxDistance >= acumulatedSwimDistance && acumulatedSwimDistance > distance) {
            System.out.printf("%s поплыл еще %d м...\n", name, distance);

        } else if (restSwimDistance < 0 && (distance + restSwimDistance) > 0 && acumulatedSwimDistanceBefore > 0) {
            System.out.printf("%s поплыл %d из %d м., так как проплыл уже %d м. и устал...\n",
                    name, (distance + restSwimDistance), distance, (acumulatedSwimDistance - distance));

        } else if (restSwimDistance < 0 && (distance + restSwimDistance) > 0) {
            System.out.printf("%s поплыл %d из %d м., так как не в силах проплыть больше %d м...\n",
                    name, (distance + restSwimDistance), distance, maxDistance);

        } else {
            System.out.printf("%s устал и уже не в силах плыть, так как проплыл %d м...\n",
                    name, maxDistance);
        }
    }

}
