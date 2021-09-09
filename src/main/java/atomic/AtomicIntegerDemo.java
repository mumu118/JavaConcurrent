package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get()  );
        atomicInteger.getAndSet(8);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndDecrement();
        System.out.println(atomicInteger.get());
        atomicInteger.getAndAdd(3);
        System.out.println(atomicInteger.get());
    }
}
