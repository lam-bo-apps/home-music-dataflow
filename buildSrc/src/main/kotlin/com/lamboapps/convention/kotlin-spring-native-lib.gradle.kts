package com.lamboapps.convention

import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("com.lamboapps.convention.kotlin-spring-native-app")
}

tasks.whenTaskAdded {
    if(this.name.startsWith("boot")) this.enabled = false
}