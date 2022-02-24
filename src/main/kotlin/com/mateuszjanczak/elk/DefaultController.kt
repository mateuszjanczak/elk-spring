package com.mateuszjanczak.elk

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DefaultController {

    private val LOG = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun test(): ResponseEntity<String> {
        LOG.info("Info message")
        LOG.warn("Warn message")
        LOG.error("Error message")

        try {
            throw Exception("Hello")
        } catch (e: Exception) {
            LOG.error("Error message with stacktrace", e)
        }

        return ResponseEntity.ok("World")
    }

}