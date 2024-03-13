package com.project.todolistapi.utils

import org.springframework.data.repository.config.RepositoryNameSpaceHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception


@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequests(e: IllegalArgumentException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
            ResponseEntity(e.message, HttpStatus.NOT_FOUND)
}