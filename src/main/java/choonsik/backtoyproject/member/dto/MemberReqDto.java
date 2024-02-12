package choonsik.backtoyproject.member.dto;

import lombok.*;

import java.time.LocalDateTime;

public class MemberReqDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberDto {
        private String username;
        private String password;
        private String name;
        private String email;
        private String birthDay;
        private String role;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

        @Override
        public String toString() {
            return "CreateMemberDto{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", birthDay='" + birthDay + '\'' +
                    ", role='" + role + '\'' +
                    ", createAt=" + createAt +
                    ", updateAt=" + updateAt +
                    '}';
        }
    }
}
