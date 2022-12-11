package com.lamboapps.convention

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("com.lamboapps.convention.kotlin-spring")
    id("org.springframework.experimental.aot") // Includes Spring Native
}

/**
 * Values provided during Github actions, but can be override in gradle.properties for local dev
 */
val isRegistryPublish = (project.properties.getOrDefault("registry.isPublish", "false") as String)
        .let { it.toBoolean() }
val registryUrl = project.properties.get("registry.url") as String?
val registryUsername = project.properties.get("registry.username") as String?
val registryPassword = project.properties.get("registry.password") as String?

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true") // enable native image support
    imageName = project.name.toString()
    tags = listOf("latest")
    isPublish = isRegistryPublish
    docker {
        publishRegistry {
            url = registryUrl
            username = registryUsername
            password = registryPassword

        }
    }
}

/**
 * Change to true if you want to run app locally in native mode
 */
tasks.getByName<BootRun>("bootRun") {
    systemProperty("springAot", false)
}


