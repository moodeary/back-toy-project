package choonsik.backtoyproject.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("app")
public class RepeatTest {

    @ParameterizedTest
    @DisplayName("Should create shapes with different numbers of sides")
    @ValueSource(ints = {5, 5, 5, 5, 5})
    void shouldCreateShapesWithDifferentNumbersOfSides(int expectedNumberOfSides) {
        System.out.println(expectedNumberOfSides);
        assertEquals(5, expectedNumberOfSides, "일치하지 않습니다.");
    }
}
