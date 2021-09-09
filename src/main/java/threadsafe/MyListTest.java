package threadsafe;

public class MyListTest {

    public static void main(String[] args) {
        MyList myList = new MyList();

        Thread thread1 = new Thread(new MyListAdd(myList));
        Thread thread2 = new Thread(new MyListRemove(myList));

        thread1.start();
        thread2.start();

    }
}
