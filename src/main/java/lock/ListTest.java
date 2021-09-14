package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
