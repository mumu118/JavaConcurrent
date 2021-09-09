package threadsafe;

import org.openjdk.jol.info.ClassLayout;

public class MarkWordTest1 {

    private Object lock = new Object();

    public void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock){
            System.out.println(ClassLayout.parseInstance(lock).toPrintable() + Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getName() + "end");
        }
    }

    public static void main(String[] args) {

        MarkWordTest markWordTest = new MarkWordTest();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    markWordTest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"test").start();
    }
}
