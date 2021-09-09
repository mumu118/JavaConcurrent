package threadsafe;

public class DeadLock {


    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public static void main(String[] args) {
        new DeadLock().deadLockTest();
    }

    private void deadLockTest(){
        Thread thread1 = new Thread(() -> {
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2){
                synchronized (lock1){
                    System.out.println("2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
