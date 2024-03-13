package com.project.todolistapi.service

import com.project.todolistapi.dto.TaskDTO
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity

interface TaskService {

    fun createTask(taskDTO: TaskDTO): TaskDTO

    fun getAllTasks(): List<TaskDTO>

    fun getTask(id:Int): TaskDTO

    fun updateTask(taskDTO: TaskDTO): TaskDTO

    fun deleteTask(id: Int)
}