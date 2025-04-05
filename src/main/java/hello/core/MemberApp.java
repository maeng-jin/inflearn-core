package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "member A", Grade.VIP);
        System.out.println("New Member = " + member.getName());
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        System.out.println("Find Member = " + findMember.getName());
    }
}
