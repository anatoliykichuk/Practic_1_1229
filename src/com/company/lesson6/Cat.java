package com.company.lesson6;

class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;

    public Cat(String name, String kind, String sex, int age) {
        super(name, kind, sex, age);
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        int acumulatedRunDistanceBefore = acumulatedRunDistance;
        acumulatedRunDistance += distance;
        int restRunDistance = MAX_RUN_DISTANCE - acumulatedRunDistance;

        if (MAX_RUN_DISTANCE >= acumulatedRunDistance && acumulatedRunDistance == distance) {
            System.out.printf("%s побежал %d м...\n", name, distance);

        } else if (MAX_RUN_DISTANCE >= acumulatedRunDistance && acumulatedRunDistance > distance) {
            System.out.printf("%s побежал еще %d м...\n", name, distance);

        } else if (restRunDistance < 0 && (distance + restRunDistance) > 0 && acumulatedRunDistanceBefore > 0) {
            System.out.printf("%s побежал %d из %d м., так как пробежал уже %d м. и устал...\n",
                    name, (distance + restRunDistance), distance, acumulatedRunDistanceBefore);

        } else if (restRunDistance < 0 && (distance + restRunDistance) > 0) {
            System.out.printf("%s побежал %d из %d м., так как не в силах пробежать больше %d м...\n",
                    name, (distance + restRunDistance), distance, MAX_RUN_DISTANCE);

        } else {
            System.out.printf("%s устал и уже не в силах бежать, так как пробежал %d м...\n",
                    name, MAX_RUN_DISTANCE);
        }
    }

}
