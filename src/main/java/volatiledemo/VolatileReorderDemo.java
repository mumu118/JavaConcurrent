package volatiledemo;

public class VolatileReorderDemo {

    int x = 10;
    int doubleValue = 0;
    volatile boolean flag = false;

    public void update(){
        x = 100;
        flag = true;
    }

    public void doubleValueX(){
        if (!flag) {
            doubleValue = x + x;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(int doubleValue) {
        this.doubleValue = doubleValue;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        VolatileReorderDemo volatileReorderDemo = new VolatileReorderDemo();
        new Thread(() -> {
            volatileReorderDemo.update();
        }).start();

        new Thread(() -> {
            volatileReorderDemo.doubleValueX();
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(volatileReorderDemo.getX());
        System.out.println(volatileReorderDemo.getDoubleValue());
        System.out.println(volatileReorderDemo.isFlag());
    }
}
