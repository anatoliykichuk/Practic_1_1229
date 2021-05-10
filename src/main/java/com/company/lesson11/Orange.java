package com.company.lesson11;

public class Orange extends Fruit{
    private static final float DEFAULT_WEIGHT = 1.5f;
    private float weight;

    public Orange() {
        this.weight = DEFAULT_WEIGHT;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
