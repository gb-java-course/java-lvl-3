package ru.gb.level3.testclasses;

import ru.gb.level3.annotations.AfterSuite;
import ru.gb.level3.annotations.BeforeSuite;
import ru.gb.level3.annotations.Test;

public class TestClass4 {

    @BeforeSuite
    public void beforeAll() {
        System.out.println("before all invoking");
    }

    @AfterSuite
    @Test(priority = 7)
    private void test1() {
        System.out.println("test 1 invoking");
    }
}
