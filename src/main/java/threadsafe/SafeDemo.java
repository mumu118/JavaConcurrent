package threadsafe;

public class SafeDemo {

    public static void main(String[] args) {

        NumDemo numDemo = new NumDemo();

        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                numDemo.numPlus();
                System.out.println(Thread.currentThread().getName() + "-" + numDemo.getNum());
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

    }
}
