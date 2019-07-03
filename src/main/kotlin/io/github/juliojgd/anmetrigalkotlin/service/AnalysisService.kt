package io.github.juliojgd.anmetrigalkotlin.service

import io.github.juliojgd.anmetrigalkotlin.domain.structure.EstructuraEstrofa

interface AnalysisService {
     fun  getSupportedEstructuras():List<EstructuraEstrofa>

     fun  analyzeText(textToAnalyze:String):EstructuraEstrofa
}