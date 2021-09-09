package thread;

/*
实现Runnable接口
 */

public class StartThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }

    public static void main(String[] args) {

        StartThread1 s = new StartThread1();

        Thread thread = new Thread(s,"test1");
        Thread thread1 = new Thread(s,"test2");
        thread.start();
        thread1.start();

    }
}
