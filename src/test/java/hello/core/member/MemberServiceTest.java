package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void jojn() {
        // given
        Member joinMember = new Member(1L, "member A", Grade.VIP);

        // when
        memberService.join(joinMember);
        Member findMember = memberService.findMember(joinMember.getId());

        // then
        Assertions.assertThat(joinMember).isEqualTo(findMember);
    }


}