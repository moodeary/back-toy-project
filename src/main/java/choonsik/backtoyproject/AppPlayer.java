package choonsik.backtoyproject;

import choonsik.backtoyproject.Order.entity.Order;
import choonsik.backtoyproject.Order.service.OrderService;
import choonsik.backtoyproject.common.AppConfig.AppConfig;
import choonsik.backtoyproject.member.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppPlayer {

    public static void main(String[] args) {

        SpringApplication.run(BackToyProjectApplication.class, args);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Member member = new Member(1L, "황병수", "admin");

        Order order = orderService.createOrder(member, "itemA", 1000);

        System.out.println(order.toString());
    }
}
