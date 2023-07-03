import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycleOfTest {
    private int sum = 1;    // 인스턴스의 생명주기 => 클래스
    private Person person = new Person("Tommy"); // 인스턴스의 생명주기 => 클래스

    @Test
    @Order(1)
    void addingTwo() {
        System.out.println("hashCode of person = " + person.hashCode());
        this.sum += 2;
        assertThat(this.sum).isEqualTo(3);
    }

    @Test
    @Order(2)
    void addingThree() {
        System.out.println("hashCode of person = " + person.hashCode());
        this.sum += 3;
        assertThat(this.sum).isEqualTo(6);
    }

}
