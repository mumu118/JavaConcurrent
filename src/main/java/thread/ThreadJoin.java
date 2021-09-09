package thread;

/**
 * 插队
 * 实例方法
 * 线程调用此方法后，使其他线程阻塞
 * 待此线程执行结束，在执行其他线程
 * 阻塞状态（线程不能进入排队队列，阻塞原因消除后线程进入就绪状态）
 */
public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin,"test");
        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i == 50){
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
