package ru.gb.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReturnAllAfterLast4Test {

    @Test
    void returnAllAfterLast4Test1() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7});

        assertArrayEquals(new Integer[] {1, 7}, result);
    }

    @Test
    void returnAllAfterLast4Test2() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {9, 8, 5, 4, 3, 2, 1});

        assertArrayEquals(new Integer[] {3, 2, 1}, result);
    }

    @Test
    void returnAllAfterLast4Test3() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {1, 1, 1, 4, 4, 4, 4, 5});

        assertArrayEquals(new Integer[] {5}, result);
    }

    @Test
    void returnAllAfterLast4Test4() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {4, 1, 1, 3, 2, 5, 6, 5});

        assertArrayEquals(new Integer[] {1, 1, 3, 2, 5, 6, 5}, result);
    }

    @Test
    void with4InTheLastElementTest() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {1, 2, 4, 4, 2, 3, 4});

        assertNull(result);
    }

    @Test
    void only4InArrayTest() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[] {4});

        assertNull(result);
    }

    @Test
    void withoutNullArrayTest() {
        Integer[] result = Lesson6Utils.returnAllAfterLast4(new int[0]);

        assertNull(result);
    }

    @Test
    void without4InArrayTest() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> Lesson6Utils.returnAllAfterLast4(new int[]{1, 2, 9, 8, 2, 3, 6, 1, 7}));

        assertEquals("Must be at least one entry of 4", exception.getMessage());
    }
}
