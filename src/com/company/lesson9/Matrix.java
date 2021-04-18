package com.company.lesson9;

import java.util.Arrays;

public class Matrix {

    public static final int REFERENCE_SIZE = 4;

    public static String[][] getMatrix(int size, String[] content) throws MyArraySizeException {
        if (size != REFERENCE_SIZE) throw new MyArraySizeException(REFERENCE_SIZE);

        String[][]  matrix = new String[size][size];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                int i = (int) (Math.random() * content.length);
                matrix[row][column] = content[i];
            }
        }
        return matrix;
    }

    public static int getSum(String[][] matrix) throws MyArrayDataException {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                try {
                    sum += Integer.parseInt(matrix[row][column]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(matrix, row, column);
                }
            }
        }
        return sum;
    }

    public static int getSum(int size, String[] content) throws MyArraySizeException, MyArrayDataException {
        String[][]  matrix = getMatrix(size, content);
        return getSum(matrix);
    }

    public static String toString(String[][] matrix) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < matrix.length; index++) {
            builder.append(Arrays.toString(matrix[index])).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
