package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayDemo {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.length());
        atomicIntegerArray.set(0,5);
        System.out.println(atomicIntegerArray.get(0));

        atomicIntegerArray.getAndIncrement(1);
        atomicIntegerArray.getAndDecrement(2);
        System.out.println(atomicIntegerArray);

        atomicIntegerArray.getAndAdd(0,5);
        System.out.println(atomicIntegerArray);

        atomicIntegerArray.compareAndSet(0,5,20);
        System.out.println(atomicIntegerArray);

        atomicIntegerArray.compareAndSet(0,10,20);
        System.out.println(atomicIntegerArray);

    }
}
