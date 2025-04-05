package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * 주문 서비스 - 구현
 */
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문 생성 요청
     * @param memberId 회원 id
     * @param itemName 상품명
     * @param itemPrice 상품 가격
     * @return 생성 주문 정보
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member orderMember = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(orderMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}
