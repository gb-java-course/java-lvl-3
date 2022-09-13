package ru.gb.level3;

import ru.gb.level3.testclasses.TestClass1;
import ru.gb.level3.testclasses.TestClass2;
import ru.gb.level3.testclasses.TestClass3;
import ru.gb.level3.testclasses.TestClass4;

public class Lesson7 {

    public static void main(String[] args) {
        System.out.println("Start test class 1");
        try {
            TestRunner.start(TestClass1.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // before all invoking
        // test 2 invoking
        // test 3 invoking
        // test 1 invoking
        // after all invoking

        System.out.println("Start test class 2");
        try {
            TestRunner.start(TestClass2.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // before all invoking
        // test 3 invoking
        // test 2 invoking
        // test 1 invoking
        // before all invoking

        System.out.println("Start test class 3");
        try {
            TestRunner.start(TestClass3.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // java.lang.RuntimeException: Test class should have only one method with AfterSuite annotation
        //	at ru.gb.level3.TestRunner.start(TestRunner.java:37)
        //	at ru.gb.level3.Lesson7.main(Lesson7.java:37)

        System.out.println("Start test class 4");
        try {
            TestRunner.start(TestClass4.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // java.lang.RuntimeException: Test method can't have BeforeSuite or AfterSuite annotation
        //	at ru.gb.level3.TestRunner.start(TestRunner.java:43)
        //	at ru.gb.level3.Lesson7.main(Lesson7.java:49)
    }
}
