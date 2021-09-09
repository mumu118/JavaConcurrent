package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定数量线程池
 */
public class CreateThreadPoolDemo1 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            pool.execute(() ->{
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + ":" + j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
