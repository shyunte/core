package Spring.core;

import Spring.core.discount.DiscountPolicy;
import Spring.core.discount.FixDiscountPolicy;
import Spring.core.discount.RateDiscountPolicy;
import Spring.core.member.MemberRepository;
import Spring.core.member.MemberService;
import Spring.core.member.MemberServiceImpl;
import Spring.core.member.MemoryMemberRepository;
import Spring.core.order.OrderService;
import Spring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


        //@Bean memberService -> new MemoryMemeberRepository()
        //@Bean orderService ->  new MemoryMemeberRepository()

@Configuration            //설정(구성) 정보  Configuration을 사용하면 CGLIB을 통해 자식class를 만들어서 싱클톤을 만들어줌
public class AppConfig {

    @Bean
    public MemberService memberService() {

        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println(" call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
