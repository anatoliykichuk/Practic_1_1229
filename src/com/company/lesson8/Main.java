package com.company.lesson8;

import javax.sound.midi.Soundbank;

public class Main {

    public static final int OBSTACLE_COUNT = 5;
    public static final int PARTICIPANTS_COUNT = 4;

    public static void main() {
        Participant[] participants = participants();

        for (Participant participant : participants) {
            participant.run();
            participant.jump();
        }

    }

    public static Obstacle[] obstacleCourse() {
        Obstacle[] obstacleCourse = new Obstacle[OBSTACLE_COUNT];


        return obstacleCourse;
    }

    public static Participant[] participants() {
        Participant[] participants = new Participant[PARTICIPANTS_COUNT];

        participants[0] = new Human("Михаил", 10, 1.2);
        participants[1] = new Human("Петр", 8, 1.0);
        participants[2] = new Cat("Марсик", 3, 1.8);
        participants[3] = new Cat("Т-1000", 1000, 6);

        return participants;
    }

}
