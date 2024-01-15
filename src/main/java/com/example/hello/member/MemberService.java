package com.example.hello.member;

public interface MemberService {
    void join(Member member);//회원 가입
    Member findMember(Long memberId);//조회
}
