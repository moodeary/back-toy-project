package choonsik.backtoyproject.discount;

import choonsik.backtoyproject.member.entity.Member;

import java.util.Objects;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(Objects.equals(member.getRole(), "admin")) {
            return price * discountPercent /  100;
        } else {
            return 0;
        }

    }
}
