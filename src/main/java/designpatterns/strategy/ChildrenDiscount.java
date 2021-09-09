package designpatterns.strategy;

import java.math.BigDecimal;

/**
 * 具体策略类
 */
public class ChildrenDiscount implements Discount{

    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("ChildrenDiscount");
        return price.subtract(new BigDecimal("10"));
    }
}
