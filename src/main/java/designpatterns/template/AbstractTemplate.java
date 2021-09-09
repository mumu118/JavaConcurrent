package designpatterns.template;

/**
 * 模板抽象类
 * 封装不可变的，扩展可变的
 */
public abstract class AbstractTemplate {

    // 钩子方法 模板方法根据钩子方法判断基本方法的执行
    public boolean isQueue(){
        return true;
    }

    /*基本方法*/

    // 排队
    public abstract void queue();

    // 买饭
    public abstract void buy();

    // 吃饭
    public abstract void eat();

    /*模板方法*/
    public final void eatTemplate(){

        if (this.isQueue()){
            this.queue();
        }
        this.buy();
        this.eat();
    }
}
