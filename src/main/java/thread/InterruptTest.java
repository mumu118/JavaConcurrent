package thread;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "test1");

        System.out.println(thread.isInterrupted());
        thread.start();
        Thread.sleep(5000);
        System.out.println(thread.isInterrupted());

        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
