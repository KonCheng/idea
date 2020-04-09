package com.koncheng.future;

import java.util.concurrent.atomic.AtomicInteger;

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

    private final String FUTURE_THREAD_PREFIX = "FUTURE-";
    private final AtomicInteger NEXT_COUNTER = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + NEXT_COUNTER.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> futureTask = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            futureTask.finish(null);
        }, getNextName()).start();
        return futureTask;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> futureTask = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            futureTask.finish(result);
        }).start();
        return futureTask;
    }
}
