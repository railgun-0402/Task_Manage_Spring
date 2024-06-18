package com.example.todo.repository.task;

import com.example.todo.service.task.TaskEntity;
import org.apache.ibatis.annotations.*;

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

    @Update("""
            UPDATE tasks 
            SET 
                summary = #{task.summary},
                description = #{task.description},
                status = #{task.status}
            WHERE
                id = #{task.id} 
            """)
    void update(@Param("task") TaskEntity entity);
}
