plugins {
    id("com.lamboapps.convention.kotlin-spring")
}

dependencies {
    api(project(":domain"))
    implementation(project(":driven"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}