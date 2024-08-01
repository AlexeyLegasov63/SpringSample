package com.levandr.simpleapp.service;

import com.levandr.simpleapp.entity.Task;
import com.levandr.simpleapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;


    @Override
    public List<Task> findAll() {
        log.debug("Call findAll in {}", getClass());
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        log.debug("Call findById in {}", getClass());
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        log.debug("Call save in {}", getClass());
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        log.debug("Call update in {}", getClass());
        return taskRepository.update(task);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call deleteById in {}", getClass());
        taskRepository.deleteById(id);
    }
}
