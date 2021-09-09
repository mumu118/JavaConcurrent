package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 implements Runnable{

    private ReentrantLock lock = new ReentrantLock();

    private int sum = 0;

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                sum++;
            }
            System.out.println(Thread.currentThread().getName() + "end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest1 runnable = new ReentrantLockTest1();

        for (int i = 0; i < 20; i++) {
            new Thread(runnable,"test" + i).start();
        }

        Thread.sleep(5000);
        System.out.println(runnable.sum);
    }
}
