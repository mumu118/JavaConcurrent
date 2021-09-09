package threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CreateThreadPoolErrorDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1,100,100,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100));

        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(() -> {
                try {
                    System.out.println("11111111111111");
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        while (true) {
            System.out.println("存活线程：" + poolExecutor.getActiveCount());
            System.out.println("总线程：" + poolExecutor.getTaskCount());
        }
    }
}
