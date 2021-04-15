package com.company.lesson8;

class Treadmill {

    private int length;

    public Treadmill(int length) {
        setLength(length);
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Укажите реальную длину беговой дорожки");
        }
    }

}
