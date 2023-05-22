package spring.dicontainer.withoutspring;

public interface MemberRepository {
    void save(String name);

    Member getMember(String name);
}
