package choonsik.backtoyproject.Order.service;

import choonsik.backtoyproject.Order.entity.Order;
import choonsik.backtoyproject.discount.DiscountPolicy;
import choonsik.backtoyproject.discount.FixDiscountPolicy;
import choonsik.backtoyproject.discount.RateDiscountPolicy;
import choonsik.backtoyproject.member.entity.Member;
import choonsik.backtoyproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Member member, String itemName, int itemPrice) {

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(member, itemName, itemPrice, discountPrice);
    }
}
