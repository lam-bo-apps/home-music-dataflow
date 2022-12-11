package com.lamboapps.convention

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("com.lamboapps.convention.kotlin-spring")
    id("org.springframework.experimental.aot") // Includes Spring Native
}

/**
 * Values provided during Github actions workflow
 */
val isRegistryPublish = (project.properties.getOrDefault("dataflowRegistry.isPublish", "false") as String)
        .let { it.toBoolean() }
val registryBaseUrl = project.properties.get("registry.baseUrl") as String?
val registryImagePath = project.properties.get("registry.imagePath") as String?
val registryUsername = project.properties.get("registry.username") as String?
val registryPassword = project.properties.get("registry.password") as String?

val fullImageName = listOf(registryBaseUrl, registryImagePath, project.name)
        .filterNotNull()
        .joinToString("/")

tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true") // enable native image support
    imageName = fullImageName
    tags = listOf("latest")
    isPublish = isRegistryPublish
    if(isRegistryPublish) {
        docker {
            publishRegistry {
                url = registryBaseUrl
                username = registryUsername
                password = registryPassword
            }
        }
    }
}

/**
 * Change to true if you want to run app locally in native mode
 */
tasks.getByName<BootRun>("bootRun") {
    systemProperty("springAot", false)
}


