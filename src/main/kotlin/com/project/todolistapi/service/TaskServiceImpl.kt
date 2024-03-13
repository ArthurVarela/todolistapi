package com.project.todolistapi.service

import com.project.todolistapi.dto.TaskDTO
import com.project.todolistapi.repository.TaskRepository
import com.project.todolistapi.utils.mappers.TaskMapper
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
        private val taskRepository: TaskRepository,
        private val taskMapper: TaskMapper
) : TaskService {

    override fun createTask(taskDTO: TaskDTO): TaskDTO {

        if(taskDTO.id != 0)
            throw IllegalArgumentException("ID must be 0 or null")

        val task = taskRepository.save(taskMapper.toEntity(taskDTO))
        return taskMapper.fromEntity(task)
    }

    override fun getAllTasks(): List<TaskDTO> {

        val tasks = taskRepository.getAllTasks()

        if (tasks.isEmpty())
            throw NoSuchElementException("The list of tasks are empty")

        return tasks.map {
            taskMapper.fromEntity(it)
        }
    }

    override fun getTask(id: Int): TaskDTO {

        val exists = taskRepository.existsById(id)
        if (!exists)
            throw NoSuchElementException("task with id: $id does not exist")

        return taskMapper.fromEntity(taskRepository.findById(id).get())
    }

    override fun updateTask(taskDTO: TaskDTO): TaskDTO {

        val exists = taskRepository.existsById(taskDTO.id)
        if (!exists)
            throw NoSuchElementException("task you're trying to update with id: ${taskDTO.id} does not exist")

        val task = taskMapper.toEntity(taskDTO)
        taskRepository.save(task)

        return taskMapper.fromEntity(task)
    }

    override fun deleteTask(id: Int) {

        val exists = taskRepository.existsById(id)
        if (!exists)
            throw NoSuchElementException("task you're trying to delete with id: $id does not exist")

        taskRepository.deleteById(id)
    }

}