package atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo {

    public static void main(String[] args) {

        Person person = new Person();
        person.setIndex(1);
        person.setName("test1");

        Person person1 = new Person();
        person.setIndex(2);
        person.setName("test2");

        AtomicMarkableReference atomic = new AtomicMarkableReference(person,false);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "修改前:" + atomic.getReference().toString());
            boolean b = atomic.compareAndSet(person, person1, false, true);
            System.out.println(Thread.currentThread().getName() + "修改结果" + b);
        },"test1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "修改前:" + atomic.getReference().toString());
            boolean b = atomic.compareAndSet(person, person1, true, true);
            System.out.println(Thread.currentThread().getName() + "修改结果" + b);
        },"test2").start();

    }
}
