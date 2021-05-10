package com.company.lesson14;

import java.util.Arrays;

public class Main {
    public static final int NUMBER_EXTRACTION_CRITERION = 4;
    public static final int[] NUMBERS_SEARCH_CRITERION = new int[] {1, 4};

    public static void main() {
        int[] numbers = getNumbers();
        System.out.println("Числа до извлечения:\n" + showNumbers(numbers));

        int[] exctractedNUmbers = extractNumbers(numbers);
        System.out.println("Числа после извлечения:\n" + showNumbers(exctractedNUmbers));

        if (isNumbersMeetCriterion(numbers)) {
            System.out.println("Числа " + showNumbers(numbers)
                    + " соответствуют критерю: " + showNumbers(NUMBERS_SEARCH_CRITERION));
        } else {
            System.out.println("Числа " + showNumbers(numbers)
                    + " не соответствуют критерю: " + showNumbers(NUMBERS_SEARCH_CRITERION));
        }
    }

    public static int[] extractNumbers(int[] numbers) {
        int foundIndex = numbers.length;

        try {
            foundIndex = getLastIndex(numbers);

        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return Arrays.copyOfRange(numbers, foundIndex, numbers.length);
    }

    public static int getLastIndex(int[] numbers) throws RuntimeException {
        int foundIndex = -1;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == NUMBER_EXTRACTION_CRITERION) {
                foundIndex = index;
            }
        }

        if (foundIndex >= 0 && foundIndex < numbers.length) {
            foundIndex++;
        }

        if (foundIndex == -1) {
            throw new RuntimeException();
        }

        return foundIndex;
    }

    public static boolean isNumbersMeetCriterion(int[] numbers) {
        int countOfCoincidences = 0;

        for (int numberIndex = 0; numberIndex < numbers.length; numberIndex++) {
            for (int criterionIndex = 0; criterionIndex < NUMBERS_SEARCH_CRITERION.length; criterionIndex++) {
                if (numbers[numberIndex] == NUMBERS_SEARCH_CRITERION[criterionIndex]) {
                    countOfCoincidences++;
                }
            }
        }
        return countOfCoincidences == numbers.length;
    }

    public static int[] getNumbers() {
        int minLength = 8;
        int maxLength = 10;
        int length = (int) (Math.random() * (maxLength - minLength)) + minLength;

        int[] numbers = new int[length];

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
