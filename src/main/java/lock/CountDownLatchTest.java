package lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < latch.getCount(); i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
            },"thread" + i).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
