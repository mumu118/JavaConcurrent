package lock;

import java.util.concurrent.locks.Lock;

public class SimpleMockLockTest{

    private int sum;

    public void add(Lock lock) {
        //for (int i = 0; i < 10000; i++) {
        //    sum++;
        //}
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                sum++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleMockLockTest s = new SimpleMockLockTest();
        SimpleMockLock lock = new SimpleMockLock();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                s.add(lock);
            }).start();
        }

        Thread.sleep(5000);
        System.out.println(s.sum);
    }
}
