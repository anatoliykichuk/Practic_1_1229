package com.company.lesson12;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main() {
        float[] data = initializeData();
        float[] dataParallely = initializeDataParallely();

        setFinalData(data);
        setFinalDataParallely(dataParallely);
    }

    public static float[] initializeData() {
        float[] data = new float[SIZE];

        long beginTime = System.currentTimeMillis();
        setInitialValue(data, 0, data.length);
        displayExecutionTime(beginTime, "initializeData()");

        return data;
    }

    public static float[] initializeDataParallely() {
        float[] data = new float[SIZE];

        long beginTime = System.currentTimeMillis();

        Thread firstThread = new Thread(() -> {
            setInitialValue(data, 0, HALF);
        });

        Thread secondThread = new Thread(() -> {
            setInitialValue(data, HALF, data.length);
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();

        } catch (InterruptedException exception) {
            exception.fillInStackTrace();
        }

        displayExecutionTime(beginTime, "initializeDataParallely()");

        return data;
    }

    public static void setFinalData(float[] data) {
        long beginTime = System.currentTimeMillis();
        setFinalValue(data, 0, data.length);
        displayExecutionTime(beginTime, "setFinalData()");
    }

    public static void setFinalDataParallely(float[] data) {
        long beginTime = System.currentTimeMillis();

        Thread firstThread = new Thread(() -> {
            setFinalValue(data, 0, HALF);
        });

        Thread secondThread = new Thread(() -> {
            setFinalValue(data, HALF, data.length);
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();

        } catch (InterruptedException exception) {
            exception.fillInStackTrace();
        }

        displayExecutionTime(beginTime, "setFinalDataParallely()");
    }

    public static void setInitialValue(float[] data, int initialIndex, int length) {
        float initialValue = 1.0f;

        for (int index = initialIndex; index < length; index++) {
            data[index] = initialValue;
        }
    }

    public static void setFinalValue(float[] data, int initialIndex, int length) {
        for (int index = initialIndex; index < length; index++) {
            data[index] = (float)(data[index]
                    * Math.sin(0.2f + index / 5)
                    * Math.cos(0.2f + index / 5)
                    * Math.cos(0.4f + index / 2)
            );
        }
    }

    public static void displayExecutionTime(long beginTime, String eventName) {
        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - beginTime) / 1000;
        System.out.println(eventName + ". Execution time is: " + executionTime + " sec.");
    }
}
