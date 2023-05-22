package spring.dicontainer.withoutspringv2;

public class AppConfig {

    public MemberRepository memberRepository() {
//        return new MemberRepositoryImplV1();
        return new MemberRepositoryImplV2();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
