package io.github.juliojgd.anmetrigalkotlin.domain.structure

enum class ArteVerso {
    ARTE_MAIOR, ARTE_MENOR
}

enum class TipoRima {
    ASONANTE, CONSONANTE, SIN_RIMA
}

enum class TipoAcentuacionFinal {
    AGUDA, LLANA, ESDRUJULA, SOBRE_ESDRUJULA
}

val VOGAIS = listOf<Char>('a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú')

val ESQUEMA_DESCONOCIDO = EsquemaMetrico("UNKNOWN")
val ESTRUCTURA_ESTROFA_DESCONOCIDA = EstructuraEstrofa("UNKNOWN", ESQUEMA_DESCONOCIDO, TipoRima.SIN_RIMA)

val LETTER_GENERATOR = generateSequence('a', { it + 1 })


data class InfoVerso(val versoPlain: String, val numeroSilabas: UInt, val acentuacionFinal: TipoAcentuacionFinal, val textoTrasAcento: String)
data class EsquemaMetrico(val esquemaString: String)
data class EstructuraEstrofa(val name: String, val esquema: EsquemaMetrico, val tipoRima: TipoRima)
fun encontrarEstructuraEstrofa(estrofaProcesada: Sequence<InfoVerso>): EstructuraEstrofa = ESTRUCTURA_ESTROFA_DESCONOCIDA

fun procesarEstrofa(estrofaPlain: String): Sequence<InfoVerso> = estrofaPlain.lineSequence().map { verso -> procesarVerso(verso) }



fun procesarVerso(versoPlain: String): InfoVerso = InfoVerso(versoPlain, 3.toUInt(), TipoAcentuacionFinal.LLANA, "uno")

fun tomarSoVogais(desdeAcento: String) = desdeAcento.filter { it in VOGAIS }

fun matchVersos(versos: Sequence<InfoVerso>): Int {
    val rimasMap = mutableMapOf<String, Char>()
    val esquemaMetrico = StringBuilder()


    versos.forEach {
        val rimaVerso = it.textoTrasAcento
        val rimaVersoSoVogais = tomarSoVogais(it.textoTrasAcento)
        if (rimasMap.containsKey(rimaVerso)) {
            esquemaMetrico.append(if (it.numeroSilabas.compareTo(9U) > 0) {
                rimasMap[rimaVerso]?.toUpperCase()
            } else {
                rimasMap[rimaVerso]
            })
        } else if (rimasMap.containsKey(rimaVersoSoVogais)) esquemaMetrico.append(
                if (it.numeroSilabas.compareTo(9U) > 0) {
                     rimasMap[rimaVerso]?.toUpperCase()
                  } else {
                     rimasMap[rimaVerso]
        }) else {
            val letra = LETTER_GENERATOR.take(1).first()
            val letraCase = if (it.numeroSilabas.compareTo(9U) > 0) {
                letra.toUpperCase()
            } else {
                letra
            }

            rimasMap[rimaVerso]= letraCase
            esquemaMetrico.append(letraCase)

        }
    }
    return 0;
}