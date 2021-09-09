package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreateThreadPoolDemo3 {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 3; i++) {
            pool.scheduleAtFixedRate(() -> {
                for (int j = 0; j < 30; j++) {
                    System.out.println(Thread.currentThread().getName() + "-" + j);
                }
            },0,10000, TimeUnit.MILLISECONDS);
        }
    }
}
