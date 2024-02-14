package choonsik.backtoyproject.sample;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

@Tag("app")
public class BasicTest {

    // 현재 클래스의 모든 테스트 메서드 실행 이전에 한 번만 실행
//    @BeforeAll
//    static void setup() { System.out.println("======== start ========"); }

    // 각 테스트 메서드 실행 이전에 매번 실행
//    @BeforeEach
//    void init() { System.out.println("=========================="); }

    // 각각 테스트 메서드 실행 이후에 실행
//    @AfterEach
//    void end() { System.out.println("=========================="); }

    // 현재 클레스의 모든 메서드 실행 이후에 한번만 실행
//    @AfterAll
//    static void tearDownAll() {
//        System.out.println("========= end =========");
//    }


    @DisplayName("successTest1")
    @Test
    void successTest1() {
        assumeTrue("abc".contains("a"));
    }

    @DisplayName("successTest2")
    @Test
    void successTest2() {
        assumeTrue("abc".contains("b"));
    }

    @DisplayName("groupAssertions")
    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @DisplayName("assumeTrue Test")
    @Test
    void testOnlyOnDevServer() {
        assumeTrue(true);
        assertEquals(2, "as".length(), "is always equal");
    }

    @DisplayName("assumeFalse Test")
    @Test
    void testOnlyOnPrdServer() {
        assumeFalse(false);
        assertEquals(4, "real".length(), "is always equal");
    }

    @DisplayName("assumingThat Test")
    @Test
    void testInAllEnvironments() {

        assumingThat("null".equals(System.getenv("ENV")),
                () -> {assertEquals(1, "a".length(), "is always equal");
                });

        assertEquals(3, "all".length(), "is always equal");
    }

}