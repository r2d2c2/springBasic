package com.example.hello;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import com.example.hello.member.MemberService;
import com.example.hello.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
       /* AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();*/
        //MemberService memberService=new MemberServiceImpl();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //스프링 부트 컨테이너에서 (키와 반환 값을 받기)

        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);//회원가입

        Member findMember = memberService.findMember(1L);
        //회원 조회
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
