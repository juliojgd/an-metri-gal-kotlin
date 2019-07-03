package io.github.juliojgd.anmetrigalkotlin.domain.structure

enum class ArteVerso {
    ARTE_MAIOR,ARTE_MENOR
}

enum class TipoRima {
    ASONANTE,CONSONANTE
}

data class EsquemaMetrico (val esquemaString:String)

data class EstructuraEstrofa (val name:String,val esquema:EsquemaMetrico, val tipoRima:TipoRima)