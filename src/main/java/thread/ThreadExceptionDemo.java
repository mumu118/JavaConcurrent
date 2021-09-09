package thread;

public class ThreadExceptionDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                int i = 1/0;
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.setUncaughtExceptionHandler((thread1,e) ->{
            System.out.println(e);
        });
        thread.start();
    }
}
