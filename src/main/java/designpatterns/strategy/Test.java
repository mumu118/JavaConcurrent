package designpatterns.strategy;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        MovieTicket movieTicket = new MovieTicket(new ChildrenDiscount());
        movieTicket.setPrice(new BigDecimal("80"));

        BigDecimal price = movieTicket.getDiscountPrice();
        System.out.println(price);

        MovieTicket movieTicket1 = new MovieTicket(new StudentDiscount());
        movieTicket1.setPrice(new BigDecimal("100"));

        BigDecimal price1 = movieTicket1.getDiscountPrice();
        System.out.println(price1);
    }
}
