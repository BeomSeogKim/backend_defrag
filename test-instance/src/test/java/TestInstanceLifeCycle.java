import org.junit.jupiter.api.*;

public class TestInstanceLifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll 실행");
        System.out.println("==============");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach 실행");
        System.out.println("==============");
    }

    @AfterEach
    void afterEach() {
        System.out.println("==============");
        System.out.println("AfterEach 실행");
        System.out.println("==============");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll 실행");
    }



    @Test
    void test1() {
        System.out.println("test1 실행");
    }

    @Test
    void test2() {
        System.out.println("test2 실행");
    }

}
