package com.lamboapps.dataflow.home.music

import com.lamboapps.dataflow.home.music.domain.model.Person
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint
import kotlin.system.exitProcess

@TypeHint(
        types = [Person::class],
        access = [TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_METHODS]
)
@SpringBootApplication
class BatchProcessingApplication

fun main(args: Array<String>) {
    exitProcess(SpringApplication.exit(runApplication<BatchProcessingApplication>(*args)))
}