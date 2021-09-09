package thread;

// interrupt()的功能就是让线程再次获得执行权限，打断wait、join()、sleep()等方法
public class ThreadInterrupt {

    static class InterruptDemo implements Runnable{

        private boolean flag = true;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            int count  = 0;
            while (flag){
                System.out.println("run" + count++);
            }
            System.out.println("over");
        }
    }

    public static void main(String[] args) {
        InterruptDemo interruptDemo = new InterruptDemo();
        Thread thread = new Thread();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main run" + i);
        }
        interruptDemo.setFlag(false);
    }
}
