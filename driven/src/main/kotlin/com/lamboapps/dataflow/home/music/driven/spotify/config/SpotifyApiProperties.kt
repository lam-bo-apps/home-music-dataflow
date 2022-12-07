package com.lamboapps.dataflow.home.music.driven.spotify.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "spotify-api")
@ConstructorBinding
data class SpotifyApiProperties(
        val userToken: String,
        val userTokenType: UserTokenType,
        val clientId: String,
        val clientSecret: String,
)