package com.example.endtermoop.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Class<?> cls) {
        System.out.println("Class: " + cls.getName());

        System.out.println("Fields:");
        for (Field f : cls.getDeclaredFields())
            System.out.println(" - " + f.getName());

        System.out.println("Methods:");
        for (Method m : cls.getDeclaredMethods())
            System.out.println(" - " + m.getName());
    }
}
