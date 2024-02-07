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
        private String loginId;
        private String password;
        private String name;
        private String email;
        private String birthDay;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

        @Override
        public String toString() {
            return "CreateMemberDto{" +
                    "loginId='" + loginId + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", birthDay='" + birthDay + '\'' +
                    ", createAt=" + createAt +
                    ", updateAt=" + updateAt +
                    '}';
        }
    }
}
