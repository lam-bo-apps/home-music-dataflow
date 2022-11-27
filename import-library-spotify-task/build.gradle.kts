plugins {
    id("com.lamboapps.convention.kotlin-spring-native")
}

dependencies {
    implementation(project(":driving"))
    implementation("org.springframework.boot:spring-boot-starter-batch")
    runtimeOnly("org.hsqldb:hsqldb")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
}