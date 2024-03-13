package com.project.todolistapi.resource

import com.project.todolistapi.dto.TaskDTO
import com.project.todolistapi.entity.Task
import com.project.todolistapi.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/tasks")
class TaskResource(
        private val taskService: TaskService
) {

    @PostMapping
    fun createTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> {
        return ResponseEntity(taskService.createTask(taskDTO), HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskDTO>> =
            ResponseEntity.ok(taskService.getAllTasks())

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Int) =
            ResponseEntity.ok(taskService.getTask(id))

    @PatchMapping
    fun updateTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> =
            ResponseEntity.ok(taskService.updateTask(taskDTO))

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Int): ResponseEntity<Unit> =
            ResponseEntity.ok(taskService.deleteTask(id))
}