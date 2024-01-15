package com.example.hello;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import com.example.hello.member.MemberService;
import com.example.hello.member.MemberServiceImpl;
import com.example.hello.order.Order;
import com.example.hello.order.OrderService;
import com.example.hello.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();//생성자 주입기를 사용하여 정의
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();

        Long memberId=1l;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);//회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //상픔 구매
        System.out.println("order = " + order);//상품 정보
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        //상품 최종 가격
    }
}
