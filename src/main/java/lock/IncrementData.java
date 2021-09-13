package lock;

import java.util.concurrent.locks.Lock;

public class IncrementData {

    private int sum = 0;

    public void sumAdd(Lock lock){
        System.out.println(Thread.currentThread().getName() + "start");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "run");
            sum++;
        } finally {
            lock.unlock();
        }
    }
}
