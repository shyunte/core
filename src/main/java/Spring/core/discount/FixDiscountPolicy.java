package Spring.core.discount;

import Spring.core.member.Grade;
import Spring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){    //ENUM 타입은 ==
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
