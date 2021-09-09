package singleton;

public class SingletonDemo4 {

    private SingletonDemo4() {
    }

    public static SingletonDemo4 getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(SingletonDemo4.getInstance());
            }).start();
        }
    }

}
