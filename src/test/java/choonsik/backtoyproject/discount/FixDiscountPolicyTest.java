package choonsik.backtoyproject.discount;

import choonsik.backtoyproject.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixDiscountPolicyTest {
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("admin 는 10% 할인이 되어야 한다.")

    void admin_o() {

        // given
        Member member = new Member(1L, "황병수", "admin");

        // when
        int discount = discountPolicy.discount(member,15000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("admin 이 아니면 할인되지 않아야 한다.")

    void admin_x() {

        // given
        Member member = new Member(1L, "황병수", "basic");

        // when
        int discount = discountPolicy.discount(member,20000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}