package Spring.core.discount;

import Spring.core.annotation.MainDiscountPolicy;
import Spring.core.member.Grade;
import Spring.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
//@Primary  //여러개 빈이 있을때 우선권을 가짐.
@MainDiscountPolicy
public class RateDiscountPolicy implements  DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price *discountPercent / 100;
        }else{
            return 0;
        }
    }
}
