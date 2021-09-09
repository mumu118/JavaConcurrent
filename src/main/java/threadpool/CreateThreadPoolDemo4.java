package threadpool;

import java.util.concurrent.*;

/**
 * corePoolSize 核心线程数 maximumPoolSize 最大线程数
 * （1）当在线程池接收到新任务，并且当前工作线程数少于corePoolSize时，即使其他工作线程处于空闲状态,
 *  也会创建一个新线程来处理该请求，直到线程数达到corePoolSize.
 *  (2）如果当前工作线程数多于corePoolSize数量，但小于maximumPoolSize数量，那么仅当任务排队队列已满时才会创建新线程.
 *  通过设置corePoolSize和maximumPoolSize相同，可以创建一个固定大小的线程池.
 *  (3）当maximumPoolSize被设置为无界值（如Integer.MAX_VALUE）时，线程池可以接收任意数量的并发任务.
 *  (4）corePoolSize和maximumPoolSize不仅能在线程池构造时设置，也可以调用setCorePoolSize()和setMaximumPoolSize()
 *  两个方法进行动态更改.
 * BlockingQueue 阻塞队列
 * keepAliveTime 空闲线程存活时间
 */
public class CreateThreadPoolDemo4 {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
               null, (RejectedExecutionHandler) null);
    }
}
