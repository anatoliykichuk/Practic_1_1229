package com.company.lesson9;

import org.w3c.dom.DOMStringList;

import java.util.Random;

public class Main {

    public static void main() {

        String[][] matrix = getMatrix(4);
        int sum = sumOfMatrix(matrix);

    }

    public static int sumOfMatrix(String[][] matrix) throws MyArraySizeException, ClassCastException {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                sum += Integer.parseInt(matrix[row][column]);
            }
        }
        return sum;
    }

    public static String[][] getMatrix(int size) {
        String[][] matrix = new String[size][size];
        String[] content = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "-"};

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                int i = (int) (Math.random() * content.length);
                matrix[row][column] = content[i];
            }
        }
        return matrix;
    }

}
