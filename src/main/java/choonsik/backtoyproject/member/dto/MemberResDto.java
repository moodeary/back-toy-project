package choonsik.backtoyproject.member.dto;

import choonsik.backtoyproject.todolist.entity.ToDoList;
import lombok.*;

import java.time.LocalDateTime;

public class MemberResDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResponseDto {
        private String loginId;
        private String nickName;
        private String password;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

    }
}
