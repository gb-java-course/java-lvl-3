package ru.gb.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckIfArrayHasOnly1sAnd4sTest {

    @Test
    void checkIfArrayHasOnly1sAnd4sTest1() {
        assertTrue(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[] {1, 4}));
    }

    @Test
    void checkIfArrayHasOnly1sAnd4sTest2() {
        assertTrue(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[] {1, 4, 1, 4, 1, 4, 1, 4}));
    }

    @Test
    void checkIfArrayHasOnly1sAnd4sTest3() {
        assertTrue(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[] {1, 1, 1, 1, 4, 4, 4, 4}));
    }

    @Test
    void checkIfArrayHasOnly1sAnd4sTest4() {
        assertFalse(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[0]));
    }

    @Test
    void checkIfArrayHasOnly1sAnd4sTest5() {
        assertFalse(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[] {2, 3, 5, 1, 4}));
    }

    @Test
    void checkIfArrayHasOnly1sAnd4sTest6() {
        assertFalse(Lesson6Utils.checkIfArrayHasOnly1sAnd4s(new int[] {1, 1, 1, 3, 4, 4, 4, 4}));
    }
}
