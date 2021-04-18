package com.company.lesson9;

public class MyArrayDataException extends Exception{

    String[][] array;
    int row;
    int column;

    public MyArrayDataException(String[][] array, int row, int column) {
        this.array = array;
        this.row = row;
        this.column = column;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        message.append("Failed to convert string value to integer in cell ")
                .append(row).append(":").append(column)
                .append(" (").append(array[row][column]).append(")");

        return message.toString();
    }
}
