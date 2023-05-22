package spring.dicontainer.withspring;

public interface MemberRepository {
    void save(String name);

    Member getMember(String name);
}
