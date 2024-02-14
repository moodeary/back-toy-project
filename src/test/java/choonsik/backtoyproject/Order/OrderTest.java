package choonsik.backtoyproject.Order;

import choonsik.backtoyproject.common.AppConfig.AppConfig;
import choonsik.backtoyproject.Order.entity.Order;
import choonsik.backtoyproject.Order.service.OrderService;
import choonsik.backtoyproject.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class OrderTest {

    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
    }



    @Test
    void createOrder() {

        Member member = new Member(1L, "황병수", "admin");

        Order order = orderService.createOrder(member, "itemA", 1000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}