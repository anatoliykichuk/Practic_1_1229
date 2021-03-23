package com.company.lesson1;

public class Main {

    public static void main() {
        viewDataTypes();

        System.out.println(calculate(3.14f, 25.2f, 15.1f, 9.7f));

        boolean inRange = inRange(9, 6, 10, 20);

        showTheNumberIsPositive(1);
        sayHello("Вася");

        verifyYearIsLeap(20);
        verifyYearIsLeap(100);
        verifyYearIsLeap(400);
        verifyYearIsLeap(125);
        verifyYearIsLeap(2020);
        verifyYearIsLeap(2021);
    }

    public static void viewDataTypes() {
        // primitive types
        byte numByte = 60;
        short numShort = 3600;
        int numInt = 86400;
        long numLong = 86400L;
        float numFloat = 36.6f;
        double numDouble = 36.6;

        char symbol = 's';

        boolean isHealthy = true;
        boolean isSick = false;

        // reference types
        String ourUniversity = "GeekBrains";
    }

    public static float calculate(float num1, float num2, float num3, float num4) {
        return num1 * (num2 + (num3 / num4));
    }

    public static boolean inRange(int a, int b, int min, int max) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void showTheNumberIsPositive(int num) {
        if (isNegative(num)) {
            System.out.printf("Число %d - отрицательное\n", num);
        } else {
            System.out.printf("Число %d - положительное\n", num);
        }
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static void sayHello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    public static void verifyYearIsLeap(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.printf("%d год является високосным.\n", year);
        } else {
            System.out.printf("%d год не является високосным.\n", year);
        }
    }
}
