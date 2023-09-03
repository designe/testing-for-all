import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ConfidenceIntervalTest {

    companion object {
        @JvmStatic
        fun provideTestArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1,2,3,4,5), 1.761, 4.24),
                Arguments.of(intArrayOf(6,7,8,9,10), 6.761, 9.24),
                Arguments.of(intArrayOf(11,12,13,14,15), 11.761, 14.24),
                Arguments.of(intArrayOf(1, 3, 5, 7, 9, 11, 13), 4.037, 9.964)
                // mean = 7, n = 7, std = 36 + 16 + 4 + 0 + 4 + 16 + 36 = root(112 / 7) = 4
            )
        }
    }
    lateinit var confidenceInterval: ConfidenceInterval
    @BeforeEach
    fun setUp() {
        confidenceInterval = ConfidenceInterval()
    }

    @Test
    fun ci95() {
        // given
        val expectedResult:CiResult = CiResult(1.7603871572139953, 4.239612842786005)

        // when
        val result = confidenceInterval.ci95(intArrayOf(1,2,3,4,5))

        // then
        assertEquals(expectedResult.min, result.min)
        assertEquals(expectedResult.max, result.max)
    }

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    fun ci95_round(samples: IntArray, ciMin: Double, ciMax: Double) {
        // given
        val expectedResult:CiResult = CiResult(ciMin, ciMax)

        // when
        val result = confidenceInterval.ci95_round(samples, 3)

        // then
        assertEquals(expectedResult.min, result.min)
        assertEquals(expectedResult.max, result.max)
    }
}