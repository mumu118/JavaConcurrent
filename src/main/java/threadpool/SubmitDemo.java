package threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitDemo {

    public static void main(String[] args){
        //Thread thread = new Thread(() -> {
        //    for (int i = 0; i < 10000; i++) {
        //        System.out.println(Thread.currentThread().getName() + "-" + i);
        //    }
        //});
        //
        //ExecutorService pool = Executors.newFixedThreadPool(3);
        //for (int i = 0; i < 5; i++) {
        //    try {
        //        Future<?> submit = pool.submit(thread);
        //        System.out.println(submit.get());
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    } catch (ExecutionException e) {
        //        e.printStackTrace();
        //    }
        //}
        try {
            ExecutorService pool = Executors.newFixedThreadPool(3);
            for (int i = 0; i < 3; i++) {
                Future<Integer> submit = pool.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return 5;
                });
                System.out.println(submit.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
