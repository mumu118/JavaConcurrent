package threadpool;

import java.util.concurrent.*;

public class ThreadFactoryDemo implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("创建一个线程");
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2,new ThreadFactoryDemo());
        for (int i = 0; i < 5; i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
