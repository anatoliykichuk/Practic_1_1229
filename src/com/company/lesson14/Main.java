package com.company.lesson14;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final int NUMBER_EXTRACTION_CRITERION = 4;
    public static final int NUMBER_COUNT = 10;

    public static void main() {
        int[] numbers = getNumbers();
        System.out.println("Числа до извлечения:\n" + numbers.toString());

        int[] exctractedNUmbers = extractNumbers(numbers);
        System.out.println("Числа после извлечения:\n" + exctractedNUmbers.toString());
    }

    public static int[] extractNumbers(int[] numbers) {
        try {
            int findedIndex = getLastIndex(numbers);
            ArrayList<Integer> exctractedNUmbers = new ArrayList<>();
            //exctractedNUmbers.addAll(findedIndex, Arrays.asList(numbers));

            for (int index = findedIndex; index < numbers.length; index++) {
                exctractedNUmbers.add(numbers[index]);
            }
            Object[] numbersAsArray = exctractedNUmbers.toArray();

            for (int index = 0; index < numbersAsArray.length; index++) {
                exctractedNUmbers.add(numbers[index]);
            }

            //return exctractedNUmbers.toArray();

        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return int[];
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
            numbers[index] = (int) Math.random() * 25;
        }
        return numbers;
    }

}
