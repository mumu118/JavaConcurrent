package threadsafe;

public class MyListRemove implements Runnable{

    private MyList myList;

    public MyListRemove(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        synchronized (myList){
            while (myList.getSize() >= 5){
                for (int i = 1; i < 6; i++) {
                    myList.removeList(i);
                }
            }
            System.out.println("MyListRemove notify");
            myList.notify();
        }
    }
}
