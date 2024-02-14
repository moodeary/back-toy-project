package choonsik.backtoyproject.member.dto;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

public class MemberReqDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EntityListeners(AuditingEntityListener.class)
    public static class CreateMemberDto {
        private String username;
        private String password;
        private String name;
        private String email;
        private String birthDay;
        private String role;




        @Override
        public String toString() {
            return "CreateMemberDto{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", birthDay='" + birthDay + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }
}
