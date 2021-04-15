package com.company.lesson8;

public abstract class Obstacle {

    private int limit;

    public Obstacle(int limit) {
        this.limit = limit;
    }

    public void go(int limit) {
        if (limit > 0) {
            this.limit = limit;
        } else {
            System.out.println("Укажите реальную высоту стены");
        }
    }

}
