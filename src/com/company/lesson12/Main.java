package com.company.lesson12;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main() {
        float[] data = initializeData();
        float[] dataOptimally = initializeDataOptimally();

        setFinalData(data);
        setFinalDataOptimally(dataOptimally);
    }

    public static float[] initializeData() {
        float[] data = new float[SIZE];

        long beginTime = System.currentTimeMillis();

        setInitialValue(data, 0, data.length);

        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - beginTime) / 1000;
        System.out.println("initializeData(). Execution time is: " + executionTime + " sec.");

        return data;
    }

    public static float[] initializeDataOptimally() {
        float[] data = new float[SIZE];

        long beginTime = System.currentTimeMillis();

        Thread firstThread = new Thread(() -> {
            System.out.println("Запуск 1-го потока");
            setInitialValue(data, 0, HALF);
            System.out.println("Завершение 1-го потока");
        });

        Thread secondThread = new Thread(() -> {
            System.out.println("Запуск 2-го потока");
            setInitialValue(data, HALF, data.length);
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
        System.out.println("initializeDataOptimally(). Execution time is: " + executionTime + " sec.");

        return data;
    }

    public static void setFinalData(float[] data) {
        long beginTime = System.currentTimeMillis();

        setFinalValue(data, 0, data.length);

        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - beginTime) / 1000;
        System.out.println("initializeData(). Execution time is: " + executionTime + " sec.");
    }

    public static void setFinalDataOptimally(float[] data) {
        long beginTime = System.currentTimeMillis();

        Thread firstThread = new Thread(() -> {
            System.out.println("Запуск 1-го потока");
            setFinalValue(data, 0, HALF);
            System.out.println("Завершение 1-го потока");
        });

        Thread secondThread = new Thread(() -> {
            System.out.println("Запуск 2-го потока");
            setFinalValue(data, HALF, data.length);
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
        System.out.println("initializeDataOptimally(). Execution time is: " + executionTime + " sec.");
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
}
