package com.company.lesson13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static final AtomicInteger racePosition = new AtomicInteger();
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier brrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier brrier) {
        CARS_COUNT++;

        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + CARS_COUNT;
        this.brrier = brrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            brrier.await();
            brrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        System.err.println(this.name + " занял " + racePosition.incrementAndGet() + " место");

        try {
            brrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
