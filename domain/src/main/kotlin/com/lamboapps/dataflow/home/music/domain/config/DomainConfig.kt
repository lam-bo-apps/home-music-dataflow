package com.lamboapps.dataflow.home.music.domain.config

import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.domain.model.UserFavoriteTrack
import org.springframework.context.annotation.Configuration
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint

@TypeHint(
        types = [Track::class, UserFavoriteTrack::class, UserFavoriteTrack::class],
        access = [TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.PUBLIC_METHODS]
)
@Configuration
class DomainConfig