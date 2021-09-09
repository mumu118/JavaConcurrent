package thread;

public class WaitsetDemo {
    // waitset 在线程wait()方法执行后，会被放入被锁对象的一个waitset里面去，而当前wait()的位置也会被记录。
    // 线程被唤醒后 重新获取锁，而是从wait处之后的代码开始继续执行
    private final static Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
               synchronized (object){
                   System.out.println(Thread.currentThread().getName() + " --- > will wait ....");
                   try {
                       object.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                System.out.println(Thread.currentThread().getName() + " --- > will leave ....");
            },"thred" + i).start();

        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (object) {

                    object.notify();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }).start();

        }
    }
}
