@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }

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
