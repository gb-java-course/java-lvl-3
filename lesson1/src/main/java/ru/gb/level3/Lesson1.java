package ru.gb.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        System.out.println("task1 =========================");

        Integer[] ints = new Integer[] {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(ints));

        swapTwoElements(ints, 2, 5);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.equals(ints, new Integer[] {1, 2, 6, 4, 5, 3}));
    }

    private static <T> void swapTwoElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void task2() {
        System.out.println("task2 =========================");

        Integer[] intArray = new Integer[] {1, 2, 3, 4, 5, 6};
        List<Integer> list = arrayToList(intArray);
        System.out.println(list);
    }

    private static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

    private static void task3() {
        System.out.println("task3 =========================");

        Box<Apple> appleBox1 = buildAppleBoxList(5);
        Box<Orange> orangeBox1 = buildOrangeBoxList(5);
        Box<Apple> appleBox2 = buildAppleBoxList(5);
        Box<Orange> orangeBox2 = buildOrangeBoxList(5);

        System.out.println(appleBox1.getWeight() == 5.0f); // true
        System.out.println(orangeBox1.getWeight() == 7.5f); // true

        System.out.println(appleBox1.compare(appleBox2)); // true
        System.out.println(orangeBox1.compare(orangeBox2)); // true

        System.out.println(appleBox1.compare(orangeBox1)); // false
        System.out.println(appleBox2.compare(orangeBox2)); // false

        Box<Apple> appleBox3 = buildAppleBoxList(6);
        Box<Orange> orangeBox3 = buildOrangeBoxList(4);
        System.out.println(appleBox3.compare(orangeBox3)); // true

//        appleBox1.moveFruits(orangeBox1); COMPILE ERROR
//        orangeBox1.moveFruits(appleBox1); COMPILE ERROR

        appleBox1.takeAllFrom(appleBox2);
        System.out.println(appleBox1.getWeight() == 10f); // true
        System.out.println(appleBox2.getWeight() == 0f); // true

        orangeBox1.takeAllFrom(orangeBox2);
        System.out.println(orangeBox1.getWeight() == 15f); // true
        System.out.println(orangeBox2.getWeight() == 0f); // true
    }

    private static Box<Apple> buildAppleBoxList(int count) {
        Box<Apple> box = new Box<>();
        for (int i = 0; i < count; i++) {
            box.add(new Apple());
        }
        return box;
    }

    private static Box<Orange> buildOrangeBoxList(int count) {
        Box<Orange> box = new Box<>();
        for (int i = 0; i < count; i++) {
            box.add(new Orange());
        }
        return box;
    }
}
