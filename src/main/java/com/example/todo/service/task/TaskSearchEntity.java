package com.example.todo.service.task;

import java.io.Serializable;
import java.util.List;

public record TaskSearchEntity (
        String summary,
        List<TaskStatus> status
) implements Serializable {
    private static final long serialVersionUID = 1L;
}
