package Spring.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StateFulServiceTest {

    @Test
    void stateFulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        //쓰레드A 사용자가 10000원 주문
        stateFulService1.order("userA", 10000);

        //쓰레드B 사용자가 20000원 주문
        stateFulService2.order("userB", 20000);

        //쓰레드 A 주문금액 조회
        int price = stateFulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(stateFulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}
