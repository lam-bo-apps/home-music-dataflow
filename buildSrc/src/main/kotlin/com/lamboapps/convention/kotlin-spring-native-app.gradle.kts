package com.lamboapps.convention

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("com.lamboapps.convention.kotlin-spring")
    id("org.springframework.experimental.aot") // Includes Spring Native
}

val imageRegistry = project.properties.get("imageRegistry") as String
val bootRunInNativeMode = false

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true") // enable native image support
    imageName = imageRegistry + project.name.toString()
    tags = listOf("latest")
}

tasks.getByName<BootRun>("bootRun") {
    systemProperty("springAot", bootRunInNativeMode)
}


