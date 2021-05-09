package com.company.lesson14;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final int NUMBER_EXTRACTION_CRITERION = 4;
    public static final int NUMBER_COUNT = 10;

    public static void main() {
        int[] numbers = getNumbers();
        System.out.println("Числа до извлечения:\n" + showNumbers(numbers));

        int[] exctractedNUmbers = extractNumbers(numbers);
        System.out.println("Числа после извлечения:\n" + showNumbers(exctractedNUmbers));
    }

    public static int[] extractNumbers(int[] numbers) {
        try {
            int findedIndex = getLastIndex(numbers);
            ArrayList<Integer> extractedNumbersAsList = new ArrayList<>();

            for (int index = findedIndex; index < numbers.length; index++) {
                extractedNumbersAsList.add(numbers[index]);
            }
            Object[] extractedNumbersAsObject = extractedNumbersAsList.toArray();
            int[] exctractedNumbers = new int[extractedNumbersAsObject.length];

            for (int index = 0; index < extractedNumbersAsObject.length; index++) {
                exctractedNumbers[index] = (int) extractedNumbersAsObject[index];
            }
            return exctractedNumbers;

        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return new int[0];
    }

    public static int getLastIndex(int[] numbers) throws RuntimeException {
        int findedIndex = -1;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == NUMBER_EXTRACTION_CRITERION) {
                findedIndex = index;
            }
        }

        if (findedIndex >= 0 && findedIndex < numbers.length - 1) {
            findedIndex++;
        }

        if (findedIndex == -1) {
            throw new RuntimeException();
        }

        return findedIndex;
    }

    public static int[] getNumbers() {
        int[] numbers = new int[NUMBER_COUNT];

        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = (int) (Math.random() * 25 + 1);
        }
        return numbers;
    }

    public static String showNumbers(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int index = 0; index < numbers.length; index++) {
            String separator = (index == numbers.length - 1) ? "" : ", ";
            builder.append(numbers[index]).append(separator);
        }
        builder.append("]");
        return builder.toString();
    }
}
