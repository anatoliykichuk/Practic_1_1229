package com.company.lesson8;

class Wall {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Укажите реальную высоту стены");
        }
    }
}
