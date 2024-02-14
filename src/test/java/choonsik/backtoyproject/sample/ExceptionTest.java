package choonsik.backtoyproject.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("app")
public class ExceptionTest {

    @DisplayName("exception : type error")
    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @DisplayName("exception : /by zero")
    @Test
    void shouldThrowException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int divide = 1/0;
        });
        assertEquals("/ by zero", exception.getMessage());
    }
}
