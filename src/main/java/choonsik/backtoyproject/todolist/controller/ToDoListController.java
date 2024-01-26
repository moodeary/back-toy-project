package choonsik.backtoyproject.todolist.controller;

import choonsik.backtoyproject.todolist.dto.ToDoListReqDto.ToDoListSaveDto;
import choonsik.backtoyproject.todolist.dto.ToDoListReqDto.ToDoListPatchDto;
import choonsik.backtoyproject.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todo")
public class ToDoListController {
    private final ToDoListService toDoListService;

    @PostMapping("/save")
    public ResponseEntity<?> toDoSave(@RequestBody ToDoListSaveDto saveDto) {
        return new ResponseEntity<>(toDoListService.todoSave(saveDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{todoId}")
    public ResponseEntity<?> toDoPatch(@PathVariable("todoId") Long todoId,
                                       @RequestBody ToDoListPatchDto patchDto) {


        return new ResponseEntity<>(toDoListService.toDoPatch(todoId, patchDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<?> toDoDelete(@PathVariable("todoId") Long todoId) {
        toDoListService.toDoDelete(todoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> toDoGet(@RequestParam(name = "completion", required = false) String completion) {
        return new ResponseEntity<>(toDoListService.toDoGet(completion), HttpStatus.OK);
    }
}
