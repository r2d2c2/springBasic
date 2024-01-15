package com.example.hello.member;

public class MemberServiceImpl implements MemberService{//회원가입 구현체
    //구현체 하나만 있으며 Impl이로고 붙여준다(관래)

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
