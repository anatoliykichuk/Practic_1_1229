package com.company.lesson11;

public class Apple extends Fruit{
    private static final float DEFAULT_WEIGHT = 1.0f;
    private float weight;

    public Apple() {
        this.weight = DEFAULT_WEIGHT;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
