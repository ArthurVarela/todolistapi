package com.project.todolistapi.dto

data class TaskDTO(
        val id: Int,
        val name: String,
        val completed: Boolean = false
)
