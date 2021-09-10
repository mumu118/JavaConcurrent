package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("wait start");
                condition.await();
                System.out.println("wait end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"wait");

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("notify start");
                condition.signal();
                System.out.println("notify end");
            } finally {
                lock.unlock();
            }
        },"notify");

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
