package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();

//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // AppConfig 버전 -> Spring 버전 변경
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "member A", Grade.VIP);
        System.out.println("New Member = " + member.getName());
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        System.out.println("Find Member = " + findMember.getName());
    }
}
