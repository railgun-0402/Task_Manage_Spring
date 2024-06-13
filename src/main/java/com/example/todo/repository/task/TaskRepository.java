package com.example.todo.repository.task;

import com.example.todo.service.task.TaskEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

// MyBatisのアノテーション
@Mapper
public interface TaskRepository {

    @Select("SELECT id, summary, description, status FROM tasks;")
    List<TaskEntity> select();

    @Select("SELECT id, summary, description, status FROM tasks WHERE id = #{taskId};")
    Optional<TaskEntity> selectById(@Param("taskId") long taskId);

    @Insert("""
            INSERT INTO tasks (summary, description, status)
            VALUES (#{task.summary}, #{task.description}, #{task.status})
            """)
    void insert(@Param("task") TaskEntity newEntity);
}
