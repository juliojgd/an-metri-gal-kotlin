package io.github.juliojgd.anmetrigalkotlin.domain.utils

data class Various(val name: String, val size: Long)

enum class OrderDirection {
    ASC, DESC
}

data class FileStatsResourceDto(val name: String, val size: Long?, val lastUpdated: Long?) {
    companion object {
        const val SORT_BY_NAME_FIELD = "name"
        const val SORT_BY_SIZE_FIELD = "size"

    }
}


fun compare(f1: FileStatsResourceDto, f2: FileStatsResourceDto, sortField: String, orderDirection: OrderDirection): Int =
        when (sortField) {
            FileStatsResourceDto.SORT_BY_NAME_FIELD -> f1.name.compareTo(f2.name)
            FileStatsResourceDto.SORT_BY_SIZE_FIELD -> f1.size?.compareTo(f2.size ?: Long.MIN_VALUE) ?: 1
            else -> 0
        } * (if (OrderDirection.DESC == orderDirection) -1 else 1)


