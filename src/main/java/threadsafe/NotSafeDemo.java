package threadsafe;

public class NotSafeDemo {

    static class NumDemo extends Thread{

        private int num = 1;
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                num ++;
                System.out.println(Thread.currentThread().getName() + "-" + i + "-" + num);
            }
        }
    }

    public static void main(String[] args) {
        NumDemo numDemo = new NumDemo();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(numDemo);
            thread.start();
        }
        System.out.println(numDemo.num);
        Class c = NumDemo.class;
        System.out.println(c);
    }

}
