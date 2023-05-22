package spring.dicontainer.withoutspringv2;

public interface MemberService {
    void join(String name);

    Member getMember(String name);
}
