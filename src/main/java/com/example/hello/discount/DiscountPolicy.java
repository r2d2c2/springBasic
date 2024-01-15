package com.example.hello.discount;

import com.example.hello.member.Member;

public interface DiscountPolicy {
    /**
     * 
     * @param member
     * @param price
     * @return 할인대상
     */
    int discount(Member member,int price);
}
