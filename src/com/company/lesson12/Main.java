package com.company.lesson12;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main() {
        float[] data = initializeData();
        float[] dataOptimally = initializeDataOptimally();
    }

    public static float[] initializeData() {
        float[] data = new float[SIZE];

        for (int index = 0; index < data.length; index++) {
            data[index] = 1.0f;
        }
        return data;
    }

    public static float[] initializeDataOptimally() {
        float[] data = new float[SIZE];

        Thread firstThread = new Thread(() -> {
            try {
                setInitialValue(data, 0, HALF);
                Thread.sleep(100);

            } catch (InterruptedException exception) {
                exception.fillInStackTrace();
            }
        });

        Thread secondThread = new Thread(() -> {
            try {
                setInitialValue(data, HALF, data.length);
                Thread.sleep(100);

            } catch (InterruptedException exception) {
                exception.fillInStackTrace();
            }
        });

        return data;
    }

    public static void setInitialValue(float[] data, int initialIndex, int length) {
        float initialValue = 1.0f;

        for (int index = initialIndex; index < length; index++) {
            data[index] = initialValue;
        }
    }
}
