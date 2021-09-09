package thread;

import java.util.concurrent.FutureTask;

public class StartThread2{

    private static final int MAX_TURN = 5;
    private static final int COMPUTE_TIMES = 100000000;

    public static void main(String[] args) throws Exception {
        FutureTask<Long> future = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "starat");
            for (int i = 0; i < 300000; i++) {

                System.out.println(Thread.currentThread().getName() + i);
            }
            return 1L;
        });
        Thread thread = new Thread(future,"test1");
        thread.start();
        for (int i = 0; i < 300000; i++) {

            System.out.println(i);
        }
        Long result = future.get();
        System.out.println(result);
    }

}
