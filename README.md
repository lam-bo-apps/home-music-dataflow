# Home music dataflow (WIP)

Contains Spring Batch tasks compiled in native mode with GraalVM, following a DDD code architecture.
These tasks are used to backup Spotify library data to Firebase Datastore and synchronize liked tracks to Youtube

## Requirements

Install GraalVM Java 17 with sdkman, then install native-image with gu

```
sdk install java 22.3.r17-grl
gu install native-image
```

## Steps for jvm

TODO

## Steps for native

- Build using `./gradlew :import-library-spotify-task:nativeCompile`
- Run using `./import-library-spotify-task/build/native/nativeCompile/import-library-spotify-task`

## References

- Github example of spring native use https://github.com/jonas-tm/spring-boot-kotlin-reactive-example
- Common dependency management https://docs.gradle.org/current/userguide/platforms.html#sec:dependency-bundles
- Multi-module with
  buildSrc https://stackoverflow.com/questions/71883613/configure-kotlin-extension-for-gradle-subprojects/71892685#71892685
- Github example of multi module project with buildSrc https://github.com/mrclrchtr/gradle-kotlin-spring