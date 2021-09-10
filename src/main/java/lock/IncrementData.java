package lock;

import java.util.concurrent.locks.Lock;

public class IncrementData {

    private int sum = 0;

    public void sumAdd(Lock lock){
        lock.lock();
        try {
            sum++;
        } finally {
            lock.unlock();
        }
    }
}
