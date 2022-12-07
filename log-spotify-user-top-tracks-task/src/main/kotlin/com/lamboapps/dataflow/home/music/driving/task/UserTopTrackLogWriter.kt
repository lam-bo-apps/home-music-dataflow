package com.lamboapps.dataflow.home.music.driving.task

import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.driving.util.logger
import org.springframework.batch.item.ItemWriter

class UserTopTrackLogWriter : ItemWriter<Track> {

    private val log by logger()

    override fun write(items: MutableList<out Track>) {
        log.info("=== Logging next chunk of items ===")
        items.forEach { log.info(it.name) }
    }
}