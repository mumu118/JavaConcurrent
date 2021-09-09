package thread;


/*
继承thread创建线程
 */
public class StartThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }

    public static void main(String[] args) {

        StartThread startThread0 = new StartThread();
        startThread0.setName("test1");

        StartThread startThread1 = new StartThread();

        //System.out.println(startThread0.getState());
        startThread0.start();
        startThread1.start();
    }

}
