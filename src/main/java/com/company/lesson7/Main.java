package com.company.lesson7;

import javax.sound.midi.Soundbank;

public class Main {

    public static int cats_in_house = 3;

    public static void main() {
        Cat[] cats = cats();

        Dish dish = new Dish(14);
        dish.appendFood(12);
        System.out.println(dish.getState());

        feedCats(cats, dish);

        System.out.println(dish.getState());
        dish.appendFood(10);

        feedCats(cats, dish);

        System.out.println(dish.getState());
    }

    public static Cat[] cats() {
        Cat[] cats = new Cat[cats_in_house];

        cats[0] = new Cat("Моня", 5);
        cats[1] = new Cat("Марсик", 6);
        cats[2] = new Cat("Барсик", 9);

        return cats;
    }

    public static void feedCats(Cat[] cats, Dish dish) {
        for (Cat cat : cats) {
            cat.eat(dish);
            System.out.println(cat.getState());
        }
    }

}
