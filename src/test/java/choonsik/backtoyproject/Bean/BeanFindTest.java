package choonsik.backtoyproject.Bean;

import choonsik.backtoyproject.common.AppConfig.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinition = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinition) {
//            Object bean = ac.getBean(beanDefinitionName);
//            System.out.println("key = " + beanDefinitionName + "  ||  value = " + bean);
//        }
    }

    @Test
    @DisplayName("등록 된 애플리케이션 빈 출력하기")
    void findApplication() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//                Object bean = ac.getBean(beanDefinitionName);
//                System.out.println("key = " + beanDefinitionName + "  ||  value = " + bean);
//            }
//
//        }
    }
}
