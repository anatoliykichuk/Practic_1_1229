package com.company.lesson14;

import java.util.*;

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
        Set<Integer> uniqueNumbers = uniqueNumbers(numbers);
        Set<Integer> uniqueSearchNumbers = uniqueNumbers(NUMBERS_SEARCH_CRITERION);

        Set<Integer> combinedNumbers = new HashSet<>();
        combinedNumbers.addAll(uniqueNumbers);
        combinedNumbers.addAll(uniqueSearchNumbers);

        if (combinedNumbers.size() != uniqueSearchNumbers.size()) return false;

        int concurrenceCount = 0;

        for (Integer number : uniqueSearchNumbers) {
            if (uniqueNumbers.contains(number)) {
                concurrenceCount++;
            }
        }
        return concurrenceCount == uniqueSearchNumbers.size();
    }

    public static Set<Integer> uniqueNumbers(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int index = 0; index < numbers.length; index++) {
            uniqueNumbers.add(numbers[index]);
        }
        return uniqueNumbers;
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
