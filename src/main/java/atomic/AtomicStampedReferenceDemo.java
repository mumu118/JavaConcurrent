package atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {

        Person person = new Person();
        person.setIndex(1);
        person.setName("test");


        AtomicStampedReference atomic = new AtomicStampedReference(person,person.getIndex());

        System.out.println(atomic.getStamp());
        System.out.println(atomic.getReference().toString());

        Person person1 = new Person();
        person1.setIndex(2);
        person1.setName("test2");

        boolean b = atomic.compareAndSet(person, person1, person1.getIndex(), person1.getIndex());
        System.out.println(b);
        System.out.println(atomic.getReference().toString());
        System.out.println(atomic.getStamp());

        b = atomic.compareAndSet(person, person1, person.getIndex(), person1.getIndex());
        System.out.println(b);
        System.out.println(atomic.getReference().toString());
        System.out.println(atomic.getStamp());


    }
}
