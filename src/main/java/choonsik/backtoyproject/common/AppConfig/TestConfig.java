package choonsik.backtoyproject.common.AppConfig;

import choonsik.backtoyproject.Order.service.OrderService;
import choonsik.backtoyproject.Order.service.OrderServiceImpl;
import choonsik.backtoyproject.discount.DiscountPolicy;
import choonsik.backtoyproject.discount.FixDiscountPolicy;
import choonsik.backtoyproject.discount.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy discountPolicy2() {
        return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();

    }

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
