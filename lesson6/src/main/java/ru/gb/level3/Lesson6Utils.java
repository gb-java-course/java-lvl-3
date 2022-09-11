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

        for (int n : array) {
            if (n != 1 && n != 4) {
                return false;
            }
        }

        return true;
    }
}
