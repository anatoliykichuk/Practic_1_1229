package com.company.lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main() {
        Object[] data = getData();
        showData(data);

        replaceData(data, 2, 4);
        showData(data);

        ArrayList<Object> list = castArrayToArrayList(data);
        System.out.println(list.toString());

        Box<Apple> apples = new Box();
        apples.addFruits(new Apple());
        apples.addFruits(new Apple());
        apples.addFruits(new Apple());

        System.out.println("Weigth of apples is: " + apples.getWeight());

        Box<Orange> oranges = new Box<>();
        oranges.addFruits(new Orange());
        oranges.addFruits(new Orange());

        System.out.println("Weigth of oranges is: " + oranges.getWeight());
        System.out.println("Weigth of oranges and apples are equalse: " + oranges.compare(apples));

        Box<Orange> otherOranges = new Box<>();
        otherOranges.addFruits(new Orange());
        otherOranges.addFruits(new Orange());
        otherOranges.addFruits(new Orange());

        System.out.println("Weigth of other oranges is: " + otherOranges.getWeight());

        otherOranges.empty(oranges);

        System.out.println("Weigth of other oranges after empty is: " + otherOranges.getWeight());
        System.out.println("Weigth of oranges after addition is: " + oranges.getWeight());
    }

    public static void replaceData(Object[] data, int index1, int index2) throws ArrayIndexOutOfBoundsException {
        if (index1 >= data.length && index2 >= data.length) throw new ArrayIndexOutOfBoundsException();

        Object tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    public static void showData(Object[] data) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int index = 0; index < data.length; index++) {
            String separator = (index == data.length - 1) ? "" : ", ";
            builder.append(data[index].toString()).append(separator);
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static Object[] getData() {
        return new Object[] {
                new Object(),
                new Integer(10),
                new Integer(5),
                new Object(),
                new Double(15D)
        };
    }

    public static ArrayList<Object> castArrayToArrayList(Object[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}
