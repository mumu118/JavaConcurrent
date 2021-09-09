package thread;

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup tg1 = new ThreadGroup("tg1");

        new Thread(tg1,() -> {
            System.out.println(Thread.currentThread().getThreadGroup());
            System.out.println(tg1.getParent());
            System.out.println(tg1.getParent().activeCount());
            for (int i = 0; i < 100 ; i++) {
                System.out.println(i);
            }
        },"test1").start();

        ThreadGroup tg2 = new ThreadGroup(tg1,"tg2");
        System.out.println(tg2.getParent());
    }
}
