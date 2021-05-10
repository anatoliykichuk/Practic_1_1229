package com.company.lesson7;

class Cat {

    private String name;
    private String kind;
    private String sex;
    private int age;

    private int appetite;
    private boolean isFull;

    public Cat(String name, String kind, String sex, int age, int appetite) {
        this.name = name;
        this.kind = kind;
        this.sex = sex;
        this.age = age;
        this.appetite = appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void setAge(int age) {
        if (age > 0 || age < 30) {
            this.age = age;
        } else {
            System.out.println("Возраст должен быть реальным!");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public void eat(Dish dish){
        if (this.isFull || dish.getBalance() < this.appetite) return;

        dish.decreaseFood(this.appetite);
        this.isFull = true;
    }

    public String getState() {
        StringBuilder builder = new StringBuilder();

        if (isFull()) {
            builder.append(this.name).append(" сыт");
        } else {
            builder.append(this.name).append(" голоден");
        }
        return builder.toString();
    }

}
