package ru.gb.level3.testclasses;

import ru.gb.level3.annotations.AfterSuite;
import ru.gb.level3.annotations.BeforeSuite;
import ru.gb.level3.annotations.Test;

public class TestClass1 {

    @BeforeSuite
    public void beforeAll() {
        System.out.println("before all invoking");
    }

    @AfterSuite
    private void afterAll() {
        System.out.println("after all invoking");
    }

    @Test(priority = 7)
    private void test1() {
        System.out.println("test 1 invoking");
    }

    @Test(priority = 2)
    private void test2() {
        System.out.println("test 2 invoking");
    }

    @Test(priority = 4)
    public void test3() {
        System.out.println("test 3 invoking");
    }
}
