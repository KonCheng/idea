package com.koncheng.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader("E:\\");
        Class<?> aClass = classLoader.loadClass("com.koncheng.loader.Hello");
        System.out.println(aClass.getClassLoader());
        Constructor constructor = aClass.getConstructor();
        Object hello = constructor.newInstance();
        System.out.println(hello);
        Method method = aClass.getMethod("print");
        String result = (String) method.invoke(hello);
        System.out.println(result);
    }
}
