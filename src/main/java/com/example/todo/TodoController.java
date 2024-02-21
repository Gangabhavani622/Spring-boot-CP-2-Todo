/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.TodoService;
import com.example.todo.Todo;

@RestController
public class TodoController{
    TodoService todoService=new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodoList();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo task){
        return todoService.addTodo(task);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo task){
        return todoService.updateTodo(id, task);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id){
         todoService.deleteTodo(id);
    }
}