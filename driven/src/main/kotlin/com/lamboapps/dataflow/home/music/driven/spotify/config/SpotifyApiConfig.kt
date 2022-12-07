package com.lamboapps.dataflow.home.music.driven.spotify.config

import com.lamboapps.dataflow.home.music.domain.spi.SpotifyServiceSpi
import com.lamboapps.dataflow.home.music.driven.spotify.SpotifyApiServiceAdapter
import com.lamboapps.dataflow.home.music.driven.spotify.SpotifyTrackMapper
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import se.michaelthelin.spotify.SpotifyApi
import java.time.Clock

@Configuration
@EnableConfigurationProperties(SpotifyApiProperties::class)
class SpotifyApiConfig {

    @Bean
    fun spotifyServiceSpi(spotifyApi: SpotifyApi,
                          spotifyTrackMapper: SpotifyTrackMapper,
                          clock: Clock): SpotifyServiceSpi {
        return SpotifyApiServiceAdapter(spotifyApi, spotifyTrackMapper, clock)
    }


    @Bean
    fun spotifyApi(spotifyApiProperties: SpotifyApiProperties): SpotifyApi {
        val spotifyApiBuilder = SpotifyApi.builder()
                .setClientId(spotifyApiProperties.clientId)
                .setClientSecret(spotifyApiProperties.clientSecret)
        val token = spotifyApiProperties.userToken
        return when (spotifyApiProperties.userTokenType) {
            UserTokenType.ACCESS -> spotifyApiBuilder.setAccessToken(token).build()
            UserTokenType.REFRESH -> spotifyApiBuilder.setRefreshToken(token).build()
        }
    }

    @Bean
    fun spotifyTrackMapper(): SpotifyTrackMapper {
        return SpotifyTrackMapper()
    }

    @Bean
    fun clock(): Clock {
        return Clock.systemUTC()
    }
}