package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartThread3 {

    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //executor.execute(() -> {
        //    for (int i = 0; i < 1000; i++) {
        //        System.out.println(Thread.currentThread().getName() + ":" + i);
        //    }
        //});
        //for (int i = 0; i < 1000; i++) {
        //    System.out.println(Thread.currentThread().getName() + ":" + i);
        //}

        Future<String> future = executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            return "111";
        });
        System.out.println(future.get());
    }
}
