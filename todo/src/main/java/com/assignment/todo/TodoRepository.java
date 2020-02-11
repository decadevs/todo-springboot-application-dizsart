package com.assignment.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public final String FIND_ALL_BY_STATUS_PROGRESS = "SELECT * from todo where status = 'In-Progress'";
    @Query(value = FIND_ALL_BY_STATUS_PROGRESS, nativeQuery = true)
    public List<Todo> findAllByProgress();
    public final String FIND_ALL_BY_STATUS_COMPLETED = "SELECT * from todo where status = 'Completed'";
    @Query(value = FIND_ALL_BY_STATUS_COMPLETED, nativeQuery = true)
    public List<Todo> findAllByCompleted();
    public final String FIND_ALL_BY_STATUS_PENDING = "SELECT * from todo where status = 'Pending'";
    @Query(value = FIND_ALL_BY_STATUS_PENDING, nativeQuery = true)
    public List<Todo> findAllByPending();
}
