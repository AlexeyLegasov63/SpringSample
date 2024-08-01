package com.levandr.simpleapp.service;

import com.levandr.simpleapp.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    Task update(Task task);

    void deleteById(Long id);
}
