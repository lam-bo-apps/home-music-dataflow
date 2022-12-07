package com.lamboapps.dataflow.home.music.driving.task.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "task")
data class TaskProperties(
        val chunkSize: Int,
)