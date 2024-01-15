package com.example.hello.Member;

import com.example.hello.AppConfig;
import com.example.hello.member.Grade;
import com.example.hello.member.Member;
import com.example.hello.member.MemberService;
import com.example.hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach//@Test 실행전 무조건 실행
    public void veforeEach(){//test가 2개면 2번 실행된다
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
    }
    @Test
    void join(){
        //given 주어진 것
        Member member=new Member(1l,"memberA", Grade.VIP);
        //when 언제
        memberService.join(member);//가입
        Member findMember=memberService.findMember(1l);//조회
        //then 그리고
        Assertions.assertThat(member).isEqualTo(findMember);
        //가입한 member와 조회한 member가 같냐

    }
}
