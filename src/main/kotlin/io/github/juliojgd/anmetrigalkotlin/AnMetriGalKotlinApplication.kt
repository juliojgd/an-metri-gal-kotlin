package io.github.juliojgd.anmetrigalkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = arrayOf("io.github.juliojgd.anmetrigalkotlin.config"))
class AnMetriGalKotlinApplication

fun main(args: Array<String>) {
    runApplication<AnMetriGalKotlinApplication>(*args)
}

