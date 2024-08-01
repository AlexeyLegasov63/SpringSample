package com.levandr.simpleapp.repository;

import com.levandr.simpleapp.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    Task update(Task task);

    void deleteById(Long id);
}
