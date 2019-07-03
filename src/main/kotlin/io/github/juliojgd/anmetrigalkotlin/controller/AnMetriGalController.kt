package io.github.juliojgd.anmetrigalkotlin.controller

import io.github.juliojgd.anmetrigalkotlin.domain.structure.EstructuraEstrofa
import io.github.juliojgd.anmetrigalkotlin.service.AnalysisService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("analyze")
class AnMetriGalController (val analysisService:AnalysisService) {

    @GetMapping("supported-estructuras")
    fun  getSupportedEstructuras()=this.analysisService.getSupportedEstructuras()

    @GetMapping("analyze-text")
    fun  analyzeText(@RequestBody  textToAnalyze:String)=this.analysisService.analyzeText(textToAnalyze)
}