package com.example.todo.service.task;

public record TaskEntity(
        Long id,
        String summary,
        String description,
        TaskStatus status
) {

}
