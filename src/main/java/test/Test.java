package test;

import org.openjdk.jol.info.ClassLayout;

public class Test {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
class A{
    private int i;

    private String name;
}