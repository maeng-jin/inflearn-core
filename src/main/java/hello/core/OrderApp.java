package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // AppConfig 버전 -> Spring 버전 변경
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member createVIPMember = new Member(1L, "VIP Member", Grade.VIP);
        memberService.join(createVIPMember);

        Member createBasicMember = new Member(2L, "Basic Member", Grade.BASIC);
        memberService.join(createBasicMember);

        Member findVIPMember = memberService.findMember(createVIPMember.getId());
        Member findBasicMember = memberService.findMember(createBasicMember.getId());

        Order vipOrder = orderService.createOrder(findVIPMember.getId(), "VIP Item", 20000);
        System.out.println("vipOrder = " + vipOrder);
        System.out.println("vipOrder.calculatePrice() = " + vipOrder.calculatePrice());

        Order basicOrder = orderService.createOrder(findBasicMember.getId(), "Basic Item", 5000);
        System.out.println("basicOrder = " + basicOrder);
        System.out.println("basicOrder.calculatePrice() = " + basicOrder.calculatePrice());

    }
}
