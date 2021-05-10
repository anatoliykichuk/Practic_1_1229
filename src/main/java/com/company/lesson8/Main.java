package com.company.lesson8;

public class Main {

    public static final int OBSTACLE_COUNT = 5;
    public static final int PARTICIPANTS_COUNT = 4;

    public static void main() {
        Obstacle[] obstacleCourse = obstacleCourse();
        Participant[] participants = participants();

        for (Obstacle obstacle : obstacleCourse) {
            for (Participant participant : participants) {
                participant.run(obstacle);
                participant.jump(obstacle);
            }
        }
    }

    public static Obstacle[] obstacleCourse() {
        Obstacle[] obstacleCourse = new Obstacle[OBSTACLE_COUNT];

        obstacleCourse[0] = new Treadmill(8);
        obstacleCourse[1] = new Wall(1);

        obstacleCourse[2] = new Treadmill(4);
        obstacleCourse[3] = new Wall(1.5);

        obstacleCourse[4] = new Treadmill(50);

        return obstacleCourse;
    }

    public static Participant[] participants() {
        Participant[] participants = new Participant[PARTICIPANTS_COUNT];

        participants[0] = new Human("Михаил", 10, 1.2);
        participants[1] = new Human("Марк", 8, 1.0);
        participants[2] = new Cat("Барсик", 6, 1.8);
        participants[3] = new Cat("Т-1000", 1000, 6);

        return participants;
    }

}
