package threadsafe;

public class MyListAdd implements Runnable{

    private MyList myList;

    public MyListAdd(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        synchronized (myList){
            if (myList.getSize() < 5){
                for (int i = 1; i < 6; i++) {
                    System.out.println("add :" + i);
                    myList.add(i);
                }
            }
            System.out.println("MyListAdd wait ========");
            try {
                myList.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
