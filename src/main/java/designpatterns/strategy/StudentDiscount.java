package designpatterns.strategy;

import java.math.BigDecimal;

/**
 * 具体策略类
 */
public class StudentDiscount implements Discount{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("StudentDiscount");
        return price.multiply(new BigDecimal("0.8"));
    }
}
