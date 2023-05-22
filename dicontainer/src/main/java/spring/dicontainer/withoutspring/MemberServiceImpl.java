package spring.dicontainer.withoutspring;

public class MemberServiceImpl implements MemberService{
//    MemberRepository memberRepository = new MemberRepositoryImplV1();
    MemberRepository memberRepository = new MemberRepositoryImplV2();
    @Override
    public void join(String name) {
        memberRepository.save(name);
    }

    @Override
    public Member getMember(String name) {
        return memberRepository.getMember(name);
    }
}
