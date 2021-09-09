package singleton;

public class SingletonDemo3 {
    /**
     * 私有实例，volatile修饰的变量是具有可见性的（即被一个线程修改后，其他线程立即可见）
     */
    private volatile static SingletonDemo3 instance;

    private SingletonDemo3(){

    }

    public static SingletonDemo3 getInstance(){
        if (null == instance){
            synchronized (SingletonDemo3.class){
                // 两线程第一次判断都为null 其中一线程先获取到锁 new
                // 当另外一个线程获取到锁时 之前判断null=instance 又重新new操作
                if (null == instance){
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(SingletonDemo3.getInstance());
            }).start();
        }
    }
}
