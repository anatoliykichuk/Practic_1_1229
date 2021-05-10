package com.company.lesson9;

public class Main {

    public static void main() {
        String[] content = getMatrixContent();

        try {
            String[][] matrix = Matrix.getMatrix(4, content);
            System.out.println(Matrix.toString(matrix));
            System.out.printf("Sum of matrix values: %d", Matrix.getSum(matrix));

        } catch (MyArraySizeException exception) {
            System.out.println(exception.getMessage());

        } catch (MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String[] getMatrixContent() {
        return new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "-"};
    }

}
