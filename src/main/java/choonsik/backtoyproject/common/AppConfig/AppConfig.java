package choonsik.backtoyproject.common.AppConfig;

import choonsik.backtoyproject.Order.service.OrderService;
import choonsik.backtoyproject.Order.service.OrderServiceImpl;
import choonsik.backtoyproject.discount.DiscountPolicy;
import choonsik.backtoyproject.discount.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy discountPolicy2() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
