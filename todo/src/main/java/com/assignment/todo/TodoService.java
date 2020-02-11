package com.assignment.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository tr;

    public List<Todo> listAll() {
        return tr.findAll();
    }

    public List<Todo> listAllCompletedTasks() {
        return tr.findAllByCompleted();
    }

    public List<Todo> listAllPendingTasks() {
        return tr.findAllByPending();
    }

    public List<Todo> listAllInProgressTasks() {
        return tr.findAllByProgress();
    }

    public void save(Todo todo){
        tr.save(todo);
    }

    public Todo get(Long id) {
        return tr.findById(id).get();
    }

    public void delete(Long id) {
        tr.deleteById(id);
    }
}
