package lock;

public class CLHLockTest {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        CLHDemo clhLock = new CLHDemo();

        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                clhLock.lock();
                sum++;
                clhLock.unlock();
            },"thread" + i).start();
        }
        Thread.sleep(10000);
        System.out.println();
        System.out.println("sum----------->>>" + sum);
    }
}
