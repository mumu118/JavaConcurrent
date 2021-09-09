package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存线程池
 * 数量不固定，只要有空闲线程就会被回收；接收到的新异步任务执行目标，查看是否有线程处于空闲状态，如果没有就直接创建新的线程。
 * 如果部分线程空闲，也就是存量线程的数量超过了处理任务数量，就会回收空闲（60秒不执行任务）线程。
 */
public class CreateThreadPoolDemo2 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "-" + j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
