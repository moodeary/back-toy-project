package choonsik.backtoyproject.todolist.dto;

import lombok.*;

public class ToDoListReqDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ToDoListSaveDto {
        private String title;

        public ToDoListSaveDto(String title) {
            this.title = title;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ToDoListPatchDto {
        private String title;
        private int completion;

        public ToDoListPatchDto(String title, int completion) {
            this.title = title;
            this.completion = completion;
        }
    }
}
