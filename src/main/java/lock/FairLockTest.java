package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockTest {

    public static void main(String[] args) {
        IncrementData incrementData = new IncrementData();
        Lock lock = new ReentrantLock(true);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                incrementData.sumAdd(lock);
            },"thread" + i).start();
        }
    }
}
