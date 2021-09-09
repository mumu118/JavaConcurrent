package singleton;

public class TestDemo {

    public static void main(String[] args) {
        new A.C();
        //内部类静态属性p2   内部类静态块   内部类属性p1    内部类属性p3  内部类普通块 内部类构造
    }
}

class A {
    private P p1 = new P("A类属性p1");
    static P p3 = new P("A类静态属性p2");

    public A() {
        System.out.println("A类构造方法");
    }

    private P p2 = new P("A类属性p3");

    static {
        System.out.println("A类静态块");
    }

    {
        System.out.println("A类普通块");
    }

    public static class C {
        private P p1 = new P("内部类属性p1");
        static P p2 = new P("内部类静态属性p2");

        public C() {
            System.out.println("内部类构造");
        }

        private P p3 = new P("内部类属性p3");

        static {
            new P("内部类静态块");
        }

        {
            new P("内部类普通块");
        }
    }
}

class P {
    public P(String s) {
        System.out.println(s);
    }
}

