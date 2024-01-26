package choonsik.backtoyproject.todolist.entity;

import choonsik.backtoyproject.todolist.dto.ToDoListReqDto.ToDoListSaveDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todo_list")
@Setter
@Getter
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int completion;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateAt;

    public ToDoList(ToDoListSaveDto toDoListSaveDto) {
        this.title = toDoListSaveDto.getTitle();
    }
}
