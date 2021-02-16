package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


//I dont know what i should do....... ADAaokcml;djcnsdsljcn


public class MyExecutor implements ExecutorService {

    ArrayList<Thread> threads = new ArrayList<>();
    Runnable sharedRun = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello, World!");
        }
    };

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }

    public void execute(int threads) throws InterruptedException {
        for (int i = 0 ; i < threads; i++) {
            this.threads.add(new Thread(sharedRun));
        }

        //Here Write the code what do you want
        for (int i = 0; i < threads; i++) {
            Thread.sleep(1000);
            this.threads.get(i).start();
        }
    }

    public void setRun(Runnable gettedRun){
        this.sharedRun = gettedRun;
    }
}
