package com.example.hello;

import com.example.hello.discount.DiscountPolicy;
import com.example.hello.discount.FixDiscountPolicy;
import com.example.hello.discount.ReteDiscountPolicy;
import com.example.hello.member.MemberRepository;
import com.example.hello.member.MemberServiceImpl;
import com.example.hello.member.MemoryMemberRepository;
import com.example.hello.order.OrderService;
import com.example.hello.order.OrderServiceImpl;

public class AppConfig {
    public MemberServiceImpl memberService(){//생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();//1000원 할인
        return new ReteDiscountPolicy();//10%할인
    }
    public OrderService orderService(){
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }

}
