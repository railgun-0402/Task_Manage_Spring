package com.example.todo.service.task;

import com.example.todo.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public List<TaskEntity> find(TaskSearchEntity taskSearchEntity) {
        return taskRepository.select(taskSearchEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskRepository.selectById(taskId);
    }

    @Transactional
    public void create(TaskEntity newEntity) {
        // DBに新規タスクを登録
        taskRepository.insert(newEntity);
    }

    @Transactional
    public void update(TaskEntity entity) {
        taskRepository.update(entity);
    }

    @Transactional
    public void delete(long id) {
        taskRepository.delete(id);
    }
}
