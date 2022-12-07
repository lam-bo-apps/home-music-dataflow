package com.lamboapps.dataflow.home.music.driving.task

import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.domain.spi.SpotifyServiceSpi
import com.lamboapps.dataflow.home.music.driving.batch.AbstractRefillingItemReader
import com.lamboapps.dataflow.home.music.driving.task.config.TaskProperties
import com.lamboapps.dataflow.home.music.driving.util.logger
import org.springframework.util.ClassUtils

class UserTopTrackSpotifyReader(private val spotifyServiceSpi: SpotifyServiceSpi,
                                private val taskProperties: TaskProperties)
    : AbstractRefillingItemReader<Track>() {

    private val log by logger()

    init {
        setName(ClassUtils.getShortName(UserTopTrackSpotifyReader::class.java))
    }

    override fun nextIterator(currentItemCount: Int): Iterator<Track> {
        log.info("=== Fetching next top tracks from Spotify Api ===")
        return spotifyServiceSpi.getUserTopTracks(currentItemCount, taskProperties.chunkSize).iterator()
    }

    override fun doOpen() {}

    override fun doClose() {}

    override fun jumpToItem(itemIndex: Int) {}
}