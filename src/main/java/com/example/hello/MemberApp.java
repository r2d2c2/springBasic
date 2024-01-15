package com.example.hello;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import com.example.hello.member.MemberService;
import com.example.hello.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        //MemberService memberService=new MemberServiceImpl();
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);//회원가입

        Member findMember = memberService.findMember(1L);
        //회원 조회
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
