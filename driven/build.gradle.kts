plugins {
    id("com.lamboapps.convention.kotlin-spring")
}

dependencies {
    implementation(project(":domain"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
