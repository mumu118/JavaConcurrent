package designpatterns.strategy;

import java.math.BigDecimal;

public class VipDiscount implements Discount{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("VipDiscount");
        System.out.println("增加积分");
        return price.multiply(new BigDecimal("0.5"));
    }
}
