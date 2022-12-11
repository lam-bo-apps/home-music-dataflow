plugins {
    id("com.lamboapps.convention.kotlin-spring-native-lib")
}

dependencies {
    api(project(":domain"))
    implementation(project(":driven"))

    implementation("org.springframework.boot:spring-boot-starter-batch")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}