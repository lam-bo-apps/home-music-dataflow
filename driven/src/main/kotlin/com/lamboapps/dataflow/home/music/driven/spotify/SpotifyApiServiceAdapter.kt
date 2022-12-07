package com.lamboapps.dataflow.home.music.driven.spotify

import com.lamboapps.dataflow.home.music.domain.model.FavoriteTrack
import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.domain.model.UserFavoriteTrack
import com.lamboapps.dataflow.home.music.domain.spi.SpotifyServiceSpi
import se.michaelthelin.spotify.SpotifyApi
import se.michaelthelin.spotify.model_objects.specification.SavedTrack
import java.time.Clock

class SpotifyApiServiceAdapter(private val spotifyApi: SpotifyApi,
                               private val spotifyTrackMapper: SpotifyTrackMapper,
                               private val clock: Clock)
    : SpotifyServiceSpi {

    init {
        if (spotifyApi.accessToken == null) {
            val credentials = spotifyApi.clientCredentials().build().execute()
            spotifyApi.accessToken = credentials.accessToken
        }
    }

    override fun getUserFavoriteTracks(offset: Int, limit: Int): List<UserFavoriteTrack> {
        return spotifyApi.usersSavedTracks
                .offset(offset)
                .limit(limit)
                .build()
                .execute()
                .items.map(responseItemToUserFavoriteTrack)
    }

    private val responseItemToUserFavoriteTrack: (SavedTrack) -> UserFavoriteTrack = {
        val track = spotifyTrackMapper.convertFromDto(it.track)
        val favoriteTrack = FavoriteTrack(
                id = it.track.id,
                lastCheckedAt = clock.instant(),
                addedAt = it.addedAt.toInstant(),
        )
        UserFavoriteTrack(track, favoriteTrack)
    }

    override fun getUserTopTracks(offset: Int, limit: Int): List<Track> {
        return spotifyApi.usersTopTracks
                .offset(offset)
                .limit(limit)
                .build()
                .execute()
                .items.map { spotifyTrackMapper.convertFromDto(it) }
    }
}