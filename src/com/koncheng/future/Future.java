package com.koncheng.future;

public interface Future<T> {

    boolean isDone();

    T get() throws InterruptedException;
}
