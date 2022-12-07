package com.lamboapps.dataflow.home.music.domain.spi

import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.domain.model.UserFavoriteTrack

interface SpotifyServiceSpi {

    fun getUserFavoriteTracks(offset: Int, limit: Int): List<UserFavoriteTrack>

    fun getUserTopTracks(offset: Int, limit: Int): List<Track>
}
