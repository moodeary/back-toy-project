package choonsik.backtoyproject.discount;

import choonsik.backtoyproject.member.entity.Member;

import java.util.Objects;

public class FixDiscountPolicy implements DiscountPolicy{


    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(Objects.equals(member.getRole(), "admin")) {
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
