package com.lamboapps.dataflow.home.music.driving.batch

import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader

abstract class AbstractRefillingItemReader<T> : AbstractItemCountingItemStreamItemReader<T>() {

    private var currentIterator: Iterator<T> = emptyList<T>().iterator()

    abstract fun nextIterator(currentItemCount: Int): Iterator<T>

    override fun doRead(): T? {
        if (!currentIterator.hasNext()) {
            currentIterator = nextIterator(this.currentItemCount)
        }
        return if (currentIterator.hasNext()) currentIterator.next() else null
    }
}