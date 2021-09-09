package designpatterns.strategy;

import java.math.BigDecimal;

/**
 * 环境类
 */
public class MovieTicket {

    private BigDecimal price;

    private Discount discount;

    public MovieTicket() {
    }

    public MovieTicket(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountPrice(){
        return this.discount.calculate(this.price);
    }
}
