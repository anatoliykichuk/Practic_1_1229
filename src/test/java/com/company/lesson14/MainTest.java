package com.company.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void extractNumbersCriterionValueIsPresent() {
        int[] numbers = new int[] {15, 4, 19, 4, 25};
        int[] expectedResult = new int[] {25};
        int[] exctractedNUmbers = Main.extractNumbers(numbers);

        Assertions.assertArrayEquals(expectedResult, exctractedNUmbers);
    }

    @Test
    void extractNumbersLastCriterionValue() {
        int[] numbers = new int[] {15, 3, 19, 9, 4};
        int[] expectedResult = new int[0];
        int[] exctractedNUmbers = Main.extractNumbers(numbers);

        Assertions.assertArrayEquals(expectedResult, exctractedNUmbers);
    }

    @Test
    void getLastIndexNoCriterionValue() {
        int[] numbers = new int[] {15, 3, 19, 9, 25};

        Assertions.assertThrows(
                RuntimeException.class,
                () -> Main.getLastIndex(numbers)
        );
    }

    @Test
    void isNumbersMeetCriterionExpectedNumbersOnly() {
        int[] numbers = new int[] {1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertEquals(true, Main.isNumbersMeetCriterion(numbers));
    }

    @Test
    void isNumbersMeetCriterionOnlyNumbers1() {
        int[] numbers = new int[] {1, 1, 1, 1, 1, 1};
        Assertions.assertEquals(false, Main.isNumbersMeetCriterion(numbers));
    }

    @Test
    void isNumbersMeetCriterionOnlyNumbers4() {
        int[] numbers = new int[] {4, 4, 4, 4};
        Assertions.assertEquals(false, Main.isNumbersMeetCriterion(numbers));
    }

    @Test
    void isNumbersMeetCriterionContanesOtherNumbers() {
        int[] numbers = new int[] {1, 1, 1, 4, 4, 1, 4, 3};
        Assertions.assertEquals(false, Main.isNumbersMeetCriterion(numbers));
    }

}
