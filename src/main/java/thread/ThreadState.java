package thread;

public class ThreadState {

    // Thread.State
    /*
    * 1.NEW 当一个线程被创建出来，还未调用start()方法，处于NEW状态
    * 2.RUNNABLE 在java虚拟机中执行的线程处于这种状态
    * 3.BLOCKED 正在等待锁的阻塞线程处于这种状态
    * 3.WAITING 不确定地等待另一线程执行某个特定操作的线程处于这种状态，进入该状态的线程需要
    *           等待其他线程作出一些特定的操作（通知或中断）
    * 4.TIMED_WAITING 在指定的等待时间内等待另外一个线程执行某个操作的线程处于这种
    *                   状态，该状态不同于WAITING，它可以在指定的时间后自行返回
    * 5.TERMINATED 已退出的线程处于这种状态
    *
    *
    * */

}
