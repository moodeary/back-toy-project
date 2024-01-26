package choonsik.backtoyproject.todolist.dto;

import choonsik.backtoyproject.todolist.entity.ToDoList;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ToDoListResDto {

    @Getter
    @Setter
    public static class ToDoDto {
        private Long id;
        private String title;
        private int completion;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

        public ToDoDto(ToDoList toDoList) {
            this.id = toDoList.getId();
            this.completion = toDoList.getCompletion();
            this.title = toDoList.getTitle();
            this.createAt = toDoList.getCreateAt();
            this.updateAt = toDoList.getUpdateAt();
        }
    }
}
