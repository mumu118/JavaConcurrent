package singleton;

//饿汉式是利用类加载机制来避免了多线程的同步问题，所以是线程安全的。
//优点：未加锁，执行效率高。
//缺点：类加载时就初始化实例，造成内存浪费。
public class SingletonDemo1 {


    /**
     * 私有实例，静态变量会在类加载的时候初始化，是线程安全的
     */
    private static final SingletonDemo1 intance = new SingletonDemo1();

    // 构造方法私有
    private SingletonDemo1() {
    }

    // 获取实例public方法
    public static SingletonDemo1 getIntance(){
        return intance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingletonDemo1.getIntance());
            }).start();
        }
    }
}
