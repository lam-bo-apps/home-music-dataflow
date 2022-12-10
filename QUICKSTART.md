## Dev Requirements

Install GraalVM Java 17 with sdkman, then install native-image with gu

```
sdk install java 22.3.r17-grl
sdk list java
sdk default java 22.3.r17-grl 
gu install native-image
```

## Spotify requirements

In the module log-spotify-user-top-tracks-task, create an `application-dev.yml` file in `resources/` with the following
content

```
spotify-api:
  user-token: changeMe
```

An access token can be fetched from the spotify console, you must request a token with the necessary scopes.
For example to log a user top tracks you can request a token from
[Spotify console](https://developer.spotify.com/console/get-current-user-top-artists-and-tracks/)

An access token is only valid for one hour before expiration. Use a refresh token instead if you want to use the same
token (See README.md for this, more complicated)

## Build and run

### Steps for jvm

Run with the profile dev to use the access token

### Steps for native

Build using `./gradlew :log-spotify-user-top-tracks-task:nativeCompile`

Run using

```
export SPOTIFY_USER_TOKEN=changeMe
./log-spotify-user-top-tracks-task/build/native/nativeCompile/log-spotify-user-top-tracks-task
```

### Steps for native container image run

With docker running, build container image using
`./gradlew :log-spotify-user-top-tracks-task:bootBuildImage`

Run using

```
export SPOTIFY_USER_TOKEN=changeMe
docker run -e "SPOTIFY_USER_TOKEN=${SPOTIFY_USER_TOKEN}" europe-west9-docker.pkg.dev/lam-bo-home/artifact-registry/log-spotify-user-top-tracks-task:latest
```


