package com.example.hello.order;

import com.example.hello.AppConfig;
import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import com.example.hello.member.MemberService;
import com.example.hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
        orderService= appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId=1l;
        Member member=new Member(memberId,"mamberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);
    }
}
