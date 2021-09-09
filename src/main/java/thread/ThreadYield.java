package thread;


/*
* yield 方法使当前线程转为RUNNABLE 就绪状态
* 让出cpu执行权 cpu重新调度
* 当前线程有可能马上重新获取到cpu执行权，也有可能让其他线程获取到cpu执行权
* */
public class ThreadYield implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"-"+"start");
        if (Thread.currentThread().getName().equals("A")){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() +"-"+"end");
    }

    public static void main(String[] args) {

        ThreadYield threadYield = new ThreadYield();

        new Thread(threadYield,"A").start();
        new Thread(threadYield,"B").start();
    }
}
