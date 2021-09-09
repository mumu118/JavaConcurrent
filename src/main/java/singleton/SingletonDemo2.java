package singleton;

public class SingletonDemo2 {

    private static SingletonDemo2 instance;

    private SingletonDemo2(){

    }

    public static synchronized SingletonDemo2 getInstance(){
        if (null == instance){
            instance = new SingletonDemo2();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonDemo2.getInstance());
            }).start();
        }
    }
}
