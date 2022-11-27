@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        gradlePluginPortal()
    }

    pluginManagement {
        repositories {
            gradlePluginPortal()
            maven { url = uri("https://repo.spring.io/release") }
            mavenCentral()
        }
    }
}

rootProject.name = "home-music-dataflow"
include(":domain")
include(":driven")
include(":driving")
include(":import-library-spotify-task")
