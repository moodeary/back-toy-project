package choonsik.backtoyproject.member.dto;

import lombok.*;
import java.time.LocalDateTime;

public class MemberResDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResponseDto {
        private String username;
        private String password;
        private String name;
        private String email;
        private String birthDay;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
    }
}
