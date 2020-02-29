package io.github.juliojgd.anmetrigalkotlin.config

import io.github.juliojgd.anmetrigalkotlin.domain.structure.EstructuraEstrofa
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@ConfigurationProperties(prefix = "anmetrigal.config")
data class AnMetriGalProperties(
    val silabaTonicaMarker: Char,
    val estrofaSeparator: Char,
    val estructuraEstrofas: Map<String, EstructuraEstrofa>
)