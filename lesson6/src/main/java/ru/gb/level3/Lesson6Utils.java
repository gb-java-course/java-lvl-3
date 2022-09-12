package ru.gb.level3;

import java.util.LinkedList;

public class Lesson6Utils {

    public static Integer[] returnAllAfterLast4(int[] array) {
        if (array.length == 0 || array[array.length - 1] == 4) {
            return null;
        }

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            if (current != 4) {
                result.addFirst(current);
            } else {
                break;
            }
        }

        if (result.size() == array.length) {
            throw new RuntimeException("Must be at least one entry of 4");
        }

        return result.toArray(new Integer[0]);
    }

    public static boolean checkIfArrayHasOnly1sAnd4s(int[] array) {
        if (array.length == 0) {
            return false;
        }

        int count1s = 0;
        int count4s = 0;
        for (int n : array) {
            if (n == 1) {
                count1s++;
            } else if (n == 4) {
                count4s++;
            } else {
                return false;
            }
        }

        if (count1s == 0 || count4s == 0) {
            return false;
        }

        return true;
    }
}
