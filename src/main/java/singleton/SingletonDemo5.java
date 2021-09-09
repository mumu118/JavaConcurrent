package singleton;

public class SingletonDemo5 {

    private SingletonDemo5(){

    }

    public static SingletonDemo5 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private final SingletonDemo5 instance;

        Singleton() {
            instance = new SingletonDemo5();
        }

        public SingletonDemo5 getInstance(){
            return instance;
        }
    }
}
