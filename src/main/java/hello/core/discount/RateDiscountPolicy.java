package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 할인 정책 - 정률 할인 정책, 구현체
 */
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        // price = 100
        // price * discountPercent = 100 * 10(1,000)
        // price * discountPercent / 100 = 100 * 10 / 100(10)

        return 0;
    }
}
