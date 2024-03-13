package com.project.todolistapi.repository

import com.project.todolistapi.dto.TaskDTO
import com.project.todolistapi.entity.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface TaskRepository: CrudRepository<Task, Int> {

    @Query("SELECT m FROM Task as m")
    fun getAllTasks(): List<Task>
}