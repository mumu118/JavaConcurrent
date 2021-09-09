package threadsafe;

import org.openjdk.jol.info.ClassLayout;

public class MarkWordTest {

    private Object lock = new Object();

    public void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock){
            System.out.println(ClassLayout.parseInstance(lock).toPrintable() + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("========");
            System.out.println(Thread.currentThread().getName() + "end");
        }
    }

    public static void main(String[] args) {

        MarkWordTest markWordTest = new MarkWordTest();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    markWordTest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"thread->" + i).start();
        }
    }
}
