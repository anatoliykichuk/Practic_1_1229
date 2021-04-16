package com.company.lesson8;

public abstract class Obstacle {

    public double limit;

    public Obstacle(double limit) {
        setLimit(limit);
    }

    public void setLimit(double limit) {
        if (limit > 0) {
            this.limit = limit;
        } else {
            System.out.println("Укажите реальное значение");
        }
    }

}
