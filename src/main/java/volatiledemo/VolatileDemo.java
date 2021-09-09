package volatiledemo;

public class VolatileDemo {

    private volatile int value = 0;

    public static void main(String[] args) throws InterruptedException {

        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileDemo.value ++;
                }
            }).start();
        }

        Thread.sleep(20000);
        System.out.println(volatileDemo.value);
    }
}
