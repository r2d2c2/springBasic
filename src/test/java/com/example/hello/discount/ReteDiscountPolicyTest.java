package com.example.hello.discount;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ReteDiscountPolicyTest {
    ReteDiscountPolicy discountPolicy=new ReteDiscountPolicy();

    @Test
    @DisplayName("vip는 10%할인이 적용되어야 한다")//junit8부터 지원
    void vip_o(){
        //give
        Member member=new Member(1l,"memberVIP", Grade.VIP);
        //when
        int discount=discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //give
        Member member=new Member(2l,"memberBASIC", Grade.BASIC);
        //when
        int discount=discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(0);
        //기본 사용자라서 할인 값은 0이 나와야 한다

    }
}