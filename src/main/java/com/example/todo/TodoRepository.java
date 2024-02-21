// Write your code here
package com.example.todo;

import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getTodoList();

    Todo getTodoById(int id);

    Todo addTodo(Todo task);

    Todo updateTodo(int id, Todo task);

    void deleteTodo(int id);
}