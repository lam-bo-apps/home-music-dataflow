plugins {
    id("com.lamboapps.convention.kotlin-spring-native")
}

dependencies {
    implementation(project(":domain"))
    api(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-batch")

    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    implementation("se.michaelthelin.spotify:spotify-web-api-java:7.2.2")
}
