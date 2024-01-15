package com.example.hello;

import com.example.hello.discount.DiscountPolicy;
import com.example.hello.discount.FixDiscountPolicy;
import com.example.hello.discount.ReteDiscountPolicy;
import com.example.hello.member.MemberRepository;
import com.example.hello.member.MemberServiceImpl;
import com.example.hello.member.MemoryMemberRepository;
import com.example.hello.order.OrderService;
import com.example.hello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean//스프링 컨테이너 추가
    public MemberServiceImpl memberService(){//생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //키는 메소드 이름이고 값은 리턴 값이다
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();//1000원 할인
        return new ReteDiscountPolicy();//10%할인
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }

}
