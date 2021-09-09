package designpatterns.template;

public class EatDemo extends AbstractTemplate {

    private boolean queueFlag;

    public EatDemo(boolean queueFlag) {
        this.queueFlag = queueFlag;
    }

    @Override
    public void queue() {
        System.out.println("排在最后一位");
    }

    @Override
    public void buy() {
        System.out.println("差点没买到");
    }

    @Override
    public void eat() {
        System.out.println("两分钟吃完");
    }

    @Override
    public boolean isQueue() {
        return this.queueFlag;
    }

    public static void main(String[] args) {

        // 不需要排队
        EatDemo eatDemo1 = new EatDemo(false);
        eatDemo1.eatTemplate();

        // 需要排队
        EatDemo eatDemo2 = new EatDemo(true);
        eatDemo2.eatTemplate();

    }
}
