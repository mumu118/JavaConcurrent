package thread;

public class InstructonReorder {

    private volatile static int x = 0, y = 0;

    private static int a = 0,b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;){
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread thread = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
            if (x == 0 && y == 0){
                System.out.println(i + ">>(" + x + "," + y + ")" );
            }
        }
    }
}
