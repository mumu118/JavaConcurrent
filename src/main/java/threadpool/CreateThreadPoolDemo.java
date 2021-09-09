package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 单线程化线程池
 也就是只有一个线程的线程池，所创建的线程池用唯一的工作线程来执行任务，使用此方法创建的线程池能保证所有任务按照指定顺序（如FIFO）执行.
 */
public class CreateThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.shutdown();
    }
}
