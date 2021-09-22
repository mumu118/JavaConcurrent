package designpatterns.proxy;

public class IServiceImpl implements IService{

    private IService target;

    public IServiceImpl(IService target) {
        this.target = target;
    }

    @Override
    public void m1() {
        System.out.println("before");
        target.m1();
        System.out.println("after");
    }

    public static void main(String[] args) {
        IServiceImpl iServiceImpl = new IServiceImpl(() -> {
            System.out.println("m1");
        });
        iServiceImpl.m1();
    }
}
