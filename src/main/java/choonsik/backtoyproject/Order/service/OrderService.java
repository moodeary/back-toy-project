package choonsik.backtoyproject.Order.service;

import choonsik.backtoyproject.Order.entity.Order;
import choonsik.backtoyproject.member.entity.Member;

public interface OrderService {
    Order createOrder(Member member, String itemName, int itemPrice);
}
