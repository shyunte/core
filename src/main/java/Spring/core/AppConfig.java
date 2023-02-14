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


@Configuration          //설정(구성) 정보
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
