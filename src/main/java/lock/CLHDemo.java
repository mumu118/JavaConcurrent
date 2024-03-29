package lock;

import java.util.concurrent.atomic.AtomicReference;

public class CLHDemo {

    private final AtomicReference<CLHNode> tailNode;

    private ThreadLocal<CLHNode> preNode;

    private ThreadLocal<CLHNode> curNode;

    public CLHDemo() {
        this.tailNode = new AtomicReference<>(new CLHNode());
        this.curNode = new ThreadLocal<CLHNode>(){
            @Override
            protected CLHNode initialValue() {
                return new CLHNode();
            }
        };
        this.preNode = new ThreadLocal<>();
    }

    public void lock(){
        CLHNode thisNode = curNode.get();
        thisNode.setLocked(true);

        // 设置当前尾结点为上一节点，设置当前节点为尾结点，
        CLHNode preNode = tailNode.getAndSet(thisNode);
        // 上一节点获取到锁，该节点等待
        while (preNode.isLocked()){
            System.out.println(Thread.currentThread().getName() + "获取锁失败，自旋等待");
        }

        System.out.println(Thread.currentThread().getName() + "获取锁成功");

    }

    public void unlock(){
        CLHNode thisNode = curNode.get();
        thisNode.setLocked(false);

        System.out.println(Thread.currentThread().getName() + "释放锁锁成功");

        CLHNode newCurNode = new CLHNode();
        curNode.set(newCurNode);
    }
}
