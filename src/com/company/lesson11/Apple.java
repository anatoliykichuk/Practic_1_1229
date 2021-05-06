package com.company.lesson11;

public class Apple extends Fruit{
    private float weight;

    public Apple() {
        this.weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
