package com.company.lesson2;

import java.util.Arrays;
import java.lang.StringBuilder;
import java.lang.Math;

public class Main {

    public static void main() {
        System.out.println("\nДомашнее задание по уроку 2:");
        rearrangeNumbers();
        fillRangeWithStep(8, 3);
        doValuesTwiceAsLarge(5);
        fillMatrixDiagonally(7);
        findMinMaxNumbers(8);
        boolean checkBalance = checkBalance(getNumbers(8));
        moveNumbers(getNumbers(4), 1);
    }

    public static void rearrangeNumbers() {
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.printf("\nЗадача 1:\nСостав массива до изменения:\t%s\n", Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;

            } else if (numbers[i] == 1) {
                numbers[i] = 0;

            }
        }
        System.out.printf("Состав массива после изменения:\t%s\n", Arrays.toString(numbers));
    }

    public static void fillRangeWithStep(int length, int step) {
        System.out.println("\nЗадача 2:");

        int[] numbers = new int[length];
        numbers[0] = 0;

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + step;
        }
        System.out.printf("Диапазон из %d чисел с шагом %d: %s\n", length, step, Arrays.toString(numbers));
    }

    public static void doValuesTwiceAsLarge(int limit) {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.printf("\nЗадача 3:\nСостав массива до изменения:\t%s\n", Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num <= limit) {
                num *= 2;
                numbers[i] = num;
            }
        }
        System.out.printf("Состав массива после изменения:\t%s\n", Arrays.toString(numbers));
    }

    public static void fillMatrixDiagonally(int length) {
        System.out.println("\nЗадача 4:");

        int[][] matrix = new int[length][length];
        StringBuilder matrixRepresentation = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                if (row == column) {
                    matrix[row][column] = 1;
                }
                matrix[row][matrix.length - row - 1] = 1;
            }
            matrixRepresentation.append(Arrays.toString(matrix[row])).append("\n");
        }
        System.out.printf("Состав матрицы размером %d х %d:\n%s",
                matrix.length, matrix.length, matrixRepresentation.toString());
    }

    public static void findMinMaxNumbers(int length) {
        System.out.println("\nЗадача 5:");

        int[] numbers = getNumbers(length);
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }

            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        System.out.printf("Минималное и максимальое значение множества %s, соответственно %d и %d\n",
                Arrays.toString(numbers), minValue, maxValue);
    }

    public static boolean checkBalance(int[] numbers) {
        System.out.printf("\nЗадача 6:\nСостав массива до изменения: %s\n", Arrays.toString(numbers));

        int sumOnLeft = 0;
        int sumOnRight = 0;

        for (int currentIndex = 0; currentIndex < numbers.length - 1; currentIndex++) {
            sumOnLeft += numbers[currentIndex];

            for (int nextIndex = currentIndex + 1; nextIndex < numbers.length; nextIndex++) {
                sumOnRight += numbers[nextIndex];
            }
            System.out.printf("Суммы левой и правой частей: %d и %d\n", sumOnLeft, sumOnRight);

            if (sumOnLeft == sumOnRight) {
                return true;
            }
            sumOnRight = 0;
        }
        return false;
    }

    public static void moveNumbers(int[] numbers, int shift) {
        System.out.printf("\nЗадача 7:\nСостав массива до изменения:\t%s\n", Arrays.toString(numbers));

        int limit = numbers.length - 1;

        if (shift > 0) {
            if (shift > limit) {
                shift -= limit;
            }
        } else {
            int shiftAbs = Math.abs(shift);

            if (shiftAbs > limit) {
                shift = 2 * limit - shiftAbs;
            } else {
                shift = limit - shiftAbs;
            }
        }

        /* TODO
        for (int i = 0; i < numbers.length - shift; i++) {

        }
        System.out.printf("\nЗадача 7:\nСостав массива до изменения:\t%s\n", Arrays.toString(numbers));
        */
        System.out.println("\n(!) Задачу 7 реализую к Пн - 29.03.");
    }

    public static int[] getNumbers(int length) {
        int[] numbers = new int [length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }
        return numbers;
    }
}
