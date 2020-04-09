package com.koncheng.loader;

public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println("BootStrap ClassLoader:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(BootStrapClassLoader.class.getClassLoader().getName());
        ClassLoader classLoader = ClassLoader.getPlatformClassLoader();
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader.getName());
        System.out.println(classLoader1.getName());
        System.out.println(classLoader.getClass().getName());
        System.out.println(classLoader1.getClass().getName());
    }
}
