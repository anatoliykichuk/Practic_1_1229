package com.company.lesson7;

class Dish {

    private int capacity;
    private int balance;

    public Dish(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBalance() {
        return balance;
    }

    public void appendFood(int units) {
        int capacityAvailable = capacity - balance;

        if (capacityAvailable >= units) {
            balance += units;
        } else {
            balance += capacityAvailable;
        }
    }

    public void decreaseFood(int units) {
        if ((balance - units) > 0) {
            balance -= units;
        } else {
            balance = 0;
        }
    }

    public String getState() {
        StringBuilder builder = new StringBuilder();

        builder.append("Емкость миски: ").append(getCapacity()).append(System.lineSeparator());
        builder.append("Остаток корма: ").append(getBalance());

        return builder.toString();
    }

}
