package com.lamboapps.dataflow.home.music.driven.spotify

import com.lamboapps.dataflow.home.music.domain.model.Track

typealias SpotifyTrack = se.michaelthelin.spotify.model_objects.specification.Track

class SpotifyTrackMapper {

    fun convertFromDto(track: SpotifyTrack): Track = Track(
            id = track.id,
            name = track.name,
    )
}