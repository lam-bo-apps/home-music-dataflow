val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    `kotlin-dsl`
}

dependencies {
    // Add necessary dependencies for plugins from gradle/libs.versions.toml
    libs.findBundle("build-src").orElseThrow().get().stream().forEach {
        implementation(it)
    }
}
