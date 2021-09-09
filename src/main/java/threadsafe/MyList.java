package threadsafe;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List<Integer> myList = new ArrayList<>();

    public void add(int i){
        myList.add(i);
    }

    public int getSize(){
        return myList.size();
    }

    public void removeList(int i) {
        System.out.println("removeList " + i);
        myList.remove(myList.indexOf(i));
    }
}
