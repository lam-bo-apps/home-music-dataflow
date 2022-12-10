plugins {
    id("com.lamboapps.convention.kotlin-spring-native-app")
}

dependencies {
    api(project(":domain"))
    api(project(":driven"))
    implementation(project(":driving"))

    implementation("org.springframework.boot:spring-boot-starter-batch")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.batch:spring-batch-test")
}