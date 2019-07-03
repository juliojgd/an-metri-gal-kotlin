package io.github.juliojgd.anmetrigalkotlin.service

import io.github.juliojgd.anmetrigalkotlin.domain.structure.EstructuraEstrofa
import io.github.juliojgd.anmetrigalkotlin.AnMetriGalProperties
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnalysisServiceImpl (val properties:AnMetriGalProperties):AnalysisService{
    override fun getSupportedEstructuras(): List<EstructuraEstrofa> =this.properties.estructuraEstrofas.values.stream().collect(Collectors.toList())


    override fun analyzeText(textToAnalyze: String): EstructuraEstrofa {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}