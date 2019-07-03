package io.github.juliojgd.anmetrigalkotlin

import io.github.juliojgd.anmetrigalkotlin.domain.structure.EsquemaMetrico
import io.github.juliojgd.anmetrigalkotlin.domain.structure.EstructuraEstrofa
import io.github.juliojgd.anmetrigalkotlin.domain.structure.TipoRima
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class AnMetriGalKotlinApplication

fun main(args: Array<String>) {
	

	println("Sample:${sample.toString()}")
	runApplication<AnMetriGalKotlinApplication>(*args)
}

@ConfigurationProperties("anmetrigal.config")
data class AnMetriGalProperties (
		val silabaTonicaMarker: Char,
		val estrofaSeparator: Char,
		val estructuraEstrofas: Map<String,EstructuraEstrofa>
)