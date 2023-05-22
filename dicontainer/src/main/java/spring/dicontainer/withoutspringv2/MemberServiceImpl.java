package spring.dicontainer.withoutspringv2;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(String name) {
        memberRepository.save(name);
    }

    @Override
    public Member getMember(String name) {
        return memberRepository.getMember(name);
    }
}
