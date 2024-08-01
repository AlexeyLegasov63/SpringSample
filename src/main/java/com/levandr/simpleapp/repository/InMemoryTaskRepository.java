package com.levandr.simpleapp.repository;

import com.levandr.simpleapp.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryTaskRepository implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        log.debug("Call findAll in {}", getClass());
        return tasks;

    }

    @Override
    public Optional<Task> findById(Long id) {
        log.debug("Call findById in {}", getClass());

        return tasks.stream().filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Task save(Task task) {
        log.debug("Call save in {}", getClass());
        task.setId(System.currentTimeMillis());
        tasks.add(task);
        return task;
    }

    @Override
    public Task update(Task task) {
        log.debug("Call update in {}", getClass());

        return findById(task.getId())
                .map(existingTask -> {
                    existingTask.setPriority(task.getPriority());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setTitle(task.getTitle());
                    return existingTask;
                })
                .orElseThrow(() -> new NoSuchElementException("Task with id " + task.getId() + "not found"));
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call deleteById in {}", getClass());
        tasks.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(tasks::remove);

    }
}
