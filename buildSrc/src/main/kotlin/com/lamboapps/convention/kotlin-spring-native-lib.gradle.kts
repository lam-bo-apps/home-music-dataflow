package com.lamboapps.convention

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("com.lamboapps.convention.kotlin-spring-native-app")
}

tasks.stream()
        .filter { it.name.startsWith("boot")}
        .forEach{ it.enabled = false }

