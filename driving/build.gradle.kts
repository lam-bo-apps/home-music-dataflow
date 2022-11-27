plugins {
    id("com.lamboapps.convention.kotlin-spring")
}

dependencies {
    implementation(project(":driven"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}