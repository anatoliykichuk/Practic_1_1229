package com.company.lesson12;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main() {
        //float[] data = initializeData();
        float[] dataOptimally = initializeDataOptimally();
    }

    public static float[] initializeData() {
        float[] data = new float[SIZE];

        setInitialValue(data, 0, data.length);
        return data;
    }

    public static float[] initializeDataOptimally() {
        float[] data = new float[SIZE];

        long beginTime = System.currentTimeMillis();

        Thread firstThread = new Thread(() -> {
            System.out.println("Запуск 1-го потока");
            setInitialValue(data, 0, HALF);

            try {
                Thread.sleep(100);

            } catch (InterruptedException exception) {
                exception.fillInStackTrace();
            }
            System.out.println("Завершение 1-го потока");
        });

        Thread secondThread = new Thread(() -> {
            System.out.println("Запуск 2-го потока");
            setInitialValue(data, HALF, data.length);

            try {
                Thread.sleep(100);

            } catch (InterruptedException exception) {
                exception.fillInStackTrace();
            }
            System.out.println("Завершение 2-го потока");
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();

        } catch (InterruptedException exception) {
            exception.fillInStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - beginTime) / 1000;

        System.out.println("Execution time is: " + executionTime + " sec.");

        return data;
    }

    public static void setInitialValue(float[] data, int initialIndex, int length) {
        float initialValue = 1.0f;

        for (int index = initialIndex; index < length; index++) {
            data[index] = initialValue;
        }
    }
}
