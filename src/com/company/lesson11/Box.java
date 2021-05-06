package com.company.lesson11;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruits(T... additionalFruits) {
        for (T fruit : additionalFruits) {
            fruits.add(fruit);
        }
    }

    public float getWeight() {
        float weight = (fruits.size() == 0) ? 0.0f : fruits.get(0).getWeight();
        return weight * fruits.size();
    }

    public boolean compare(Box<T> boxContent) {
        return false;
    }

    public void empty(Box<T> box) {
        for (T fruit : fruits) {
            box.addFruits(fruit);
        }
        fruits.clear();
    }

}
