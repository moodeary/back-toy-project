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
        private String nickName;
        private String password;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
    }
}
