package spring.dicontainer.withoutspringv2;

public interface MemberRepository {
    void save(String name);

    Member getMember(String name);
}
