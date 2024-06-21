package com.example.todo.controller.task;

import java.util.List;
import java.util.Optional;

public record TaskSearchDTO(
        String summary,
        List<String> statusList
) {
    public Boolean isChecked(String status) {
        return Optional.ofNullable(statusList)
                .map(list -> list.contains(status)) // nullではないとき
                .orElse(false);
    }
}
