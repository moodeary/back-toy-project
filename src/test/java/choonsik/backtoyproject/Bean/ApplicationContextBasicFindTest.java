package choonsik.backtoyproject.Bean;

import choonsik.backtoyproject.Order.service.OrderService;
import choonsik.backtoyproject.Order.service.OrderServiceImpl;
import choonsik.backtoyproject.common.AppConfig.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Assertions.assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        OrderService orderService = ac.getBean(OrderService.class);
        Assertions.assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        OrderService orderService = ac.getBean("orderService", OrderServiceImpl.class);
        Assertions.assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX() {
        // ()-> ac.getBean("xxxx", OrderService.class) 실행했을 떄 터지면 성공
        assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("xxxx", OrderService.class));
    }
}
