package Spring.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototype bean1");
        PrototypeBean bean = ac.getBean(PrototypeBean.class);


        System.out.println("find prototype bean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean).isNotSameAs(bean2);


        bean.destory();
        bean2.destory();
        ac.close();


    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("SingletonBean.destory");
        }

    }
}
