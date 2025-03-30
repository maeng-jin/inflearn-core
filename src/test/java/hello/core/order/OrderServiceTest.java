package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Member createVIPMember = new Member(1L, "VIP Member", Grade.VIP);
        memberService.join(createVIPMember);

        Member createBasicMember = new Member(2L, "Basic Member", Grade.BASIC);
        memberService.join(createBasicMember);

        Member findVIPMember = memberService.findMember(createVIPMember.getId());
        Member findBasicMember = memberService.findMember(createBasicMember.getId());

        Order vipOrder = orderService.createOrder(findVIPMember.getId(), "VIP Item", 5000);
        Order basicOrder = orderService.createOrder(findBasicMember.getId(), "Basic Item", 5000);

        Assertions.assertThat(vipOrder.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(basicOrder.getDiscountPrice()).isEqualTo(0);

    }
}