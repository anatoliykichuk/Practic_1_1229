package com.company.lesson6;

class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;

    public Cat(String name, String kind, String sex, int age) {
        super(name, kind, sex, age);
        id++;
    }

    public Cat(String name) {
        super(name);
        id++;
    }

    @Override
    public void run(int distance) {
        acumulatedRunDistance += distance;
        int restOfDistance = acumulatedRunDistance - MAX_RUN_DISTANCE;

        if (restOfDistance >= distance) {
            System.out.printf("%s побежал %d м...", name, distance);

        } else if (restOfDistance > 0) {
            System.out.printf("%s побежал %d из %d м., так как устал...", name, restOfDistance, distance);

        } else {
            System.out.printf("%s устал и уже не в силах бежать, так как пробежал %d м...",
                    name, restOfDistance, distance);
        }
    }

}
