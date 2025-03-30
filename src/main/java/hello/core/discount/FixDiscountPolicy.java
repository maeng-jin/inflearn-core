package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 할인 정책 - 고정 할인 정책, 구현체
 */
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1,000원 고정 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
