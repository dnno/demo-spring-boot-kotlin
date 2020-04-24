package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val demoService: DemoService) {

    @GetMapping("hello")
    fun hello(): ResponseEntity<String> {
        val content = demoService.hello()
        return ResponseEntity.ok(content)
    }
}