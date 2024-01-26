package choonsik.backtoyproject.todolist.service;

import choonsik.backtoyproject.todolist.dto.ToDoListReqDto.ToDoListPatchDto;
import choonsik.backtoyproject.todolist.dto.ToDoListReqDto.ToDoListSaveDto;
import choonsik.backtoyproject.todolist.entity.ToDoList;
import choonsik.backtoyproject.todolist.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    @Transactional
    public ToDoList todoSave(ToDoListSaveDto saveDto) {
        ToDoList toDoSave = new ToDoList(saveDto);
        return toDoListRepository.save(toDoSave);
    }

    @Transactional
    public ToDoList toDoPatch(Long todoId, ToDoListPatchDto patchDto) {

        ToDoList toDoList = toDoListRepository.findById(todoId).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
        toDoList.setTitle(patchDto.getTitle());
        toDoList.setCompletion(patchDto.getCompletion());
        return toDoList;
    }

    @Transactional
    public void toDoDelete(Long todoId) {
        toDoListRepository.deleteById(todoId);
    }

    @Transactional
    public List<ToDoList> toDoGet(String completion) {
        if (completion != null) {
            return toDoListRepository.findByCompletion(Integer.parseInt(completion));
        }
        return toDoListRepository.findAll();
    }

    @Transactional
    public ToDoList toDoGetOne(Long todoId) {
        return toDoListRepository.findById(todoId).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
    }
}
