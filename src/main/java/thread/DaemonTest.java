package thread;

public class DaemonTest {

    public static void main(String[] args) {
        Thread userThread = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"userThread");

        Thread daemonThread = new Thread(() ->{
            for (int i = 0; i < 100000; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        },"daemonThread");

        System.out.println(userThread.isDaemon());
        System.out.println(daemonThread.isDaemon());
        daemonThread.setDaemon(true);
        System.out.println(daemonThread.isDaemon());

        userThread.start();
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + "end");
    }

}
