package com.project.todolistapi.utils.mappers

import com.project.todolistapi.dto.TaskDTO
import com.project.todolistapi.entity.Task
import org.springframework.stereotype.Service

@Service
class TaskMapper: Mapper<TaskDTO, Task> {

    override fun fromEntity(entity: Task): TaskDTO = TaskDTO(
            entity.id,
            entity.name,
            entity.completed
    )

    override fun toEntity(domain: TaskDTO): Task = Task(
            domain.id,
            domain.name,
            domain.completed
    )
}