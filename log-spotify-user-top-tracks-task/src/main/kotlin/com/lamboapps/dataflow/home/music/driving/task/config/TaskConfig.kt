package com.lamboapps.dataflow.home.music.driving.task.config

import com.lamboapps.dataflow.home.music.domain.config.DomainConfig
import com.lamboapps.dataflow.home.music.domain.model.Track
import com.lamboapps.dataflow.home.music.domain.spi.SpotifyServiceSpi
import com.lamboapps.dataflow.home.music.driven.spotify.config.SpotifyApiConfig
import com.lamboapps.dataflow.home.music.driving.task.UserTopTrackLogWriter
import com.lamboapps.dataflow.home.music.driving.task.UserTopTrackSpotifyReader
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(value = [DomainConfig::class, SpotifyApiConfig::class])
@EnableBatchProcessing
@EnableConfigurationProperties(TaskProperties::class)
class TaskConfig {

    @Bean
    fun logSpotifyUserTopTracksJob(jobBuilderFactory: JobBuilderFactory,
                                   firstStep: Step): Job {
        return jobBuilderFactory["log-spotify-user-top-tracks"]
                .incrementer(RunIdIncrementer())
                .start(firstStep)
                .build()
    }

    @Bean
    fun firstStep(stepBuilderFactory: StepBuilderFactory,
                  reader: ItemReader<Track>,
                  writer: ItemWriter<Track>,
                  taskProperties: TaskProperties): Step {
        return stepBuilderFactory["spotify-api-to-log"]
                .chunk<Track, Track>(taskProperties.chunkSize)
                .reader(reader)
                .writer(writer)
                .build()
    }

    @Bean
    fun userTopTrackItemReader(spotifyServiceSpi: SpotifyServiceSpi,
                               taskProperties: TaskProperties): ItemReader<Track> {
        return UserTopTrackSpotifyReader(spotifyServiceSpi, taskProperties)
    }

    @Bean
    fun userFavoriteTrackItemWriter(): ItemWriter<Track> {
        return UserTopTrackLogWriter()
    }
}