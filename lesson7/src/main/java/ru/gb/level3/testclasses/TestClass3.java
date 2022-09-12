package ru.gb.level3.testclasses;

import ru.gb.level3.annotations.AfterSuite;
import ru.gb.level3.annotations.BeforeSuite;
import ru.gb.level3.annotations.Test;

public class TestClass3 {

    @BeforeSuite
    @AfterSuite
    public void beforeAll() {
        System.out.println("before all invoking");
    }

    @AfterSuite
    public void afterAll() {
        System.out.println("after all invoking");
    }

    @Test(priority = 7)
    private void test1() {
        System.out.println("test 1 invoking");
    }
}
