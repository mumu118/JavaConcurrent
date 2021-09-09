package threadsafe;

public class NumDemo {

    private int num = 0;

    public synchronized void numPlus(){
        num++;
    }

    public int getNum() {
        return num;
    }
}
