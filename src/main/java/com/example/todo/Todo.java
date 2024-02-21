// Write your code here
package com.example.todo;

import java.util.*;

public class Todo {
    private int id;
    private String todo;
    private String priority;
    private String status;

    public Todo(int id, String todo, String priority, String status) {
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getTodo() {
        return this.todo;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

}