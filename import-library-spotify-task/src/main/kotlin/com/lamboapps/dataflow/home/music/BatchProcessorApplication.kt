package com.lamboapps.dataflow.home.music

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.system.exitProcess

@SpringBootApplication
class BatchProcessingApplication

fun main(args: Array<String>) {
    exitProcess(SpringApplication.exit(runApplication<BatchProcessingApplication>(*args)))
}