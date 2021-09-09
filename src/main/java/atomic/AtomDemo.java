package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atom = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    atom.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + "-" +atom.get());
                }
            }).start();
        }
        Thread.sleep(20000);
        System.out.println(Thread.currentThread().getName() + "-" + atom.get());
    }
}
