package choonsik.backtoyproject.todolist.repository;

import choonsik.backtoyproject.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    List<ToDoList> findByCompletion(int completion);
}
