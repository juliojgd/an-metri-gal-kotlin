package io.github.juliojgd.anmetrigalkotlin

import io.github.juliojgd.anmetrigalkotlin.config.AnMetriGalProperties
import io.github.juliojgd.anmetrigalkotlin.domain.utils.FileStatsResourceDto
import io.github.juliojgd.anmetrigalkotlin.domain.utils.OrderDirection
import io.github.juliojgd.anmetrigalkotlin.domain.utils.compare
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AnMetriGalKotlinApplicationTests {

    @Test
    fun contextLoads() {
    }


    @Test
    fun testCompare() {
        val fA = FileStatsResourceDto("a", 1000, 1000)
        val fA2 = FileStatsResourceDto("a", 1000, 1000)

        val fB = FileStatsResourceDto("b", 2000, 2000)
        val fC = FileStatsResourceDto("c", null, 3000)
        val fD = FileStatsResourceDto("d", null, 4000)
        Assertions.assertThat(fA.size).isNotNull()
        Assertions.assertThat(fB.size).isNotNull()
        Assertions.assertThat(fA.size?.compareTo(fB.size!!)).isEqualTo(-1)
        Assertions.assertThat(fB.size?.compareTo(fA.size!!)).isEqualTo(1)

        Assertions.assertThat(fA.name?.compareTo(fB.name!!)).isEqualTo(-1)
        Assertions.assertThat(fB.name?.compareTo(fA.name!!)).isEqualTo(1)

        Assertions.assertThat(fC.size).isNull()
        Assertions.assertThat(fD.size).isNull()
        Assertions.assertThat(compare(fA, fA2, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.ASC)).isEqualTo(0)
        Assertions.assertThat(compare(fA, fA2, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.ASC)).isEqualTo(0)
        Assertions.assertThat(compare(fA, fA2, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.DESC)).isEqualTo(0)
        Assertions.assertThat(compare(fA, fA2, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.DESC)).isEqualTo(0)

        Assertions.assertThat(compare(fA, fB, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.ASC)).isEqualTo(-1)
        Assertions.assertThat(compare(fA, fB, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.DESC)).isEqualTo(1)
        Assertions.assertThat(compare(fA, fB, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.ASC)).isEqualTo(-1)
        Assertions.assertThat(compare(fA, fB, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.DESC)).isEqualTo(1)

        Assertions.assertThat(compare(fB, fC, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.ASC)).isEqualTo(-1)
        Assertions.assertThat(compare(fB, fC, FileStatsResourceDto.SORT_BY_NAME_FIELD, OrderDirection.DESC)).isEqualTo(1)
        Assertions.assertThat(compare(fB, fC, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.ASC)).isEqualTo(1)
        Assertions.assertThat(compare(fB, fC, FileStatsResourceDto.SORT_BY_SIZE_FIELD, OrderDirection.DESC)).isEqualTo(-1)


    }

    @Test
    fun testRimas() {


    }
}
