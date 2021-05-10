package com.company.lesson9;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(int referenceSize) {
        super("Matrix size mast be " + referenceSize);
    }

}
