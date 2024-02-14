package choonsik.backtoyproject.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("app")
public class NestedTest {
    @Nested
    @DisplayName("결제를 시도 할 때")
    class whenTryPay {

        @Nested
        @DisplayName("카드로 시도 할 때")
        class payWithCard {
            @Test
            @DisplayName("신용카드 결제가 성공한다")
            void successPayWithCreditCard() {

            }
            @Test
            @DisplayName("체크카드 결제가 성공한다")
            void successPayWithDebitCard() {

            }
        }
        @Nested
        @DisplayName("현금으로 시도할 때")
        class payWithCash {
            @Test
            @DisplayName("현금 결제 성공한다")
            void successPayWithCash() {

            }
        }
    }
}
