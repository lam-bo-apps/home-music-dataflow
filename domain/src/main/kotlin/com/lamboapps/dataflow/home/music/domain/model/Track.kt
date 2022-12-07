package com.lamboapps.dataflow.home.music.domain.model

import java.time.Instant

data class UserFavoriteTrack(val track: Track, val favoriteTrack: FavoriteTrack)

data class Track(
        val id: String,
        val name: String,
)

data class FavoriteTrack(
        val id: String,
        val lastCheckedAt: Instant,
        val addedAt: Instant,
)