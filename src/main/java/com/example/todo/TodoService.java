/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int uniqueId = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    public ArrayList<Todo> getTodoList() {
        Collection<Todo> todoCollection = todoList.values();
        ArrayList<Todo> todos = new ArrayList<>(todoCollection);
        return todos;
    }

    public Todo getTodoById(int id) {
        Todo task = todoList.get(id);
        if (task == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return task;
    }

    public Todo addTodo(Todo task) {
        task.setId(uniqueId);
        todoList.put(uniqueId, task);
        uniqueId++;
        return task;
    }

    public Todo updateTodo(int id, Todo task) {
        Todo todoExists = todoList.get(id);
        if (todoExists == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if (task.getTodo() != null)
            todoExists.setTodo(task.getTodo());
        if(task.getPriority()!=null) todoExists.setPriority(task.getPriority());
        if(task.getStatus()!=null) todoExists.setStatus(task.getStatus());

        return todoExists;
    }

    public void deleteTodo(int id){
        Todo todoExists=todoList.get(id);
        if(todoExists==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else{
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
