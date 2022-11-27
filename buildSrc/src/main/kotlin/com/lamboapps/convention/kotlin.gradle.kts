package com.lamboapps.convention

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    kotlin("jvm")
}

val kotlinVersion = "1.7"
val jdkVersion = "17"

kotlin {
    jvmToolchain {
        languageVersion.set(
            JavaLanguageVersion.of(jdkVersion)
        )
    }
}

tasks.compileKotlin {
    kotlinOptions {
        @Suppress("SpellCheckingInspection")
        freeCompilerArgs = listOf("-Xjsr305=strict")
        allWarningsAsErrors = true
        jvmTarget = jdkVersion
        languageVersion = kotlinVersion
        apiVersion = kotlinVersion
    }
}

tasks.compileTestKotlin {
    kotlinOptions {
        @Suppress("SpellCheckingInspection")
        freeCompilerArgs = listOf("-Xjsr305=strict")
        allWarningsAsErrors = true
        jvmTarget = jdkVersion
        languageVersion = kotlinVersion
        apiVersion = kotlinVersion
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.FULL
    }
}



