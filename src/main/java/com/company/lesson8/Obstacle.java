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

    public void setLimit(int limit) {
        if (limit > 0) {
            this.limit = (double) limit;
        } else {
            System.out.println("Укажите реальное значение");
        }
    }

    public double getLimit() {
        return limit;
    }

    boolean isPossibly(double limit) {
        return (limit >= getLimit());
    }

    boolean isPossibly(int limit) {
        return (limit >= (int) getLimit());
    }

}
