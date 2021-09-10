package lock;

import sun.misc.Lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ">>" + i);
                if ( i == 50) {
                    System.out.println("park =========");
                    LockSupport.parkUntil(5000000000000L);
                }
            }
        },"thread1");

        thread1.start();
        //Thread.sleep(5000);
        //
        //LockSupport.unpark(thread1);

    }
}
