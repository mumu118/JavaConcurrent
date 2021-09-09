package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        Person person = new Person();
        person.setIndex(1);
        person.setName("test");

        Person person1 = new Person();
        person.setIndex(2);
        person.setName("test1");

        AtomicReference<Person> atomicReference = new AtomicReference();
        atomicReference.set(person);
        System.out.println(atomicReference.get().toString());

        boolean b = atomicReference.compareAndSet(person1, person1);
        System.out.println(b);

        b = atomicReference.compareAndSet(person, person1);
        System.out.println(b);

        atomicReference.get();
    }
}
