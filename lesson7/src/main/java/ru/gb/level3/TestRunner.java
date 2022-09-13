package ru.gb.level3;

import ru.gb.level3.annotations.AfterSuite;
import ru.gb.level3.annotations.BeforeSuite;
import ru.gb.level3.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestRunner {

    public static void start(String className)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        start(clazz);
    }

    public static <T> void start(Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        ArrayList<Method> testMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Test class should have only one method with BeforeSuite annotation");
                }
                beforeSuiteMethod = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Test class should have only one method with AfterSuite annotation");
                }
                afterSuiteMethod = method;
            }
            if (method.isAnnotationPresent(Test.class)) {
                if (method == beforeSuiteMethod || method == afterSuiteMethod) {
                    throw new RuntimeException("Test method can't have BeforeSuite or AfterSuite annotation");
                }
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(it -> it.getAnnotation(Test.class).priority()));

        T instance = clazz.getConstructor().newInstance();

        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.setAccessible(true);
            beforeSuiteMethod.invoke(instance);
            beforeSuiteMethod.setAccessible(false);
        }

        testMethods.forEach(it -> {
            try {
                it.setAccessible(true);
                it.invoke(instance);
                it.setAccessible(false);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        if (afterSuiteMethod != null) {
            afterSuiteMethod.setAccessible(true);
            afterSuiteMethod.invoke(instance);
            afterSuiteMethod.setAccessible(false);
        }
    }
}
