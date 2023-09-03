import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalculatorTest {

    lateinit var calculator: Calculator
    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun increment() {
        // given (expected)
        val expected = 6

        // when
        val actual = calculator.increment(5)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun decrement() {
        // given (expected)
        val expected = 6

        // when
        val actual = calculator.decrement(7)

        // then
        assertEquals(expected, actual)
    }
}