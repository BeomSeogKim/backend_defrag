package spring.dicontainer.withoutspringv2;

import java.util.HashMap;

public class MemberRepositoryImplV1 implements MemberRepository {
    HashMap<String, Member> repository = new HashMap<>();

    @Override
    public void save(String name) {
        repository.put(name, new Member(name));
    }

    @Override
    public Member getMember(String name) {
        return repository.get(name);
    }
}
