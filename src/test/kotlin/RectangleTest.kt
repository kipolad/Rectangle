import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random
import kotlin.random.nextInt

class RectangleTest {
    @Test
    fun checkDefaultConstructorValueTest() {
        assertAll(
            { assertEquals(1, Rectangle().a, "default constructor returns wrong value") },
            { assertEquals(1, Rectangle().b, "default constructor returns wrong value") }
        )
    }

    @Test
    fun checkExceptionsTest() {
        assertAll(
            { assertThrows(ArithmeticException::class.java, { Rectangle(a = 0) }, "Side a = 0 doesn't trow an ArithmeticException") },
            { assertThrows(ArithmeticException::class.java, { Rectangle(b = 0) }, "Side b = 0 doesn't trow an ArithmeticException") },
            { assertThrows(ArithmeticException::class.java, { Rectangle(a = -1) }, "Side a = -1 doesn't trow an ArithmeticException") },
            { assertThrows(ArithmeticException::class.java, { Rectangle(b = -1) }, "Side b = -1 doesn't trow an ArithmeticException") }
        )
    }

    @Test
    fun checkConstructorTest() {
        val rectangle = Rectangle(22, 1033)
        assertAll(
            { assertEquals(22, rectangle.a, "side a returns wrong value") },
            { assertEquals(1033, rectangle.b, "side b returns wrong value") }
        )
    }

    @Test
    fun rectangleExceptionMessage() {
        val ae = assertThrows(ArithmeticException::class.java) { Rectangle(0, 10) }
        assertEquals("Side can't be less or equals than zero!", ae.message)
    }

    @ParameterizedTest
    @CsvSource("10, 90", "20, 80", "30, 70", "40, 60", "50, 50")
    fun checkPerimeterTest(a: Int, b: Int) {
        assertEquals(200, Rectangle(a, b).getPerimeter(), "getPerimeter() returns wrong square")
    }

    @ParameterizedTest
    @MethodSource("getValueForSquare")
    fun checkSquare (rectangle: Rectangle, result: Int) {
        assertEquals(rectangle.getSquare(), result, "getSquare() returns wrong square")
    }

    @ParameterizedTest
    @MethodSource("getValueForMultiSquare")
    fun checkMultiSquare(a: Int, b: Int, factor: Int, result: Int) {
        assertEquals(Rectangle(a, b).getMultiSquare(factor), result, "getMultiSquare() returns wrong result")
    }

    companion object {
        @JvmStatic
        fun getValueForSquare(): List<Arguments> {
            return (0..9).map {
                val a = Random.nextInt(1..100)
                val b = Random.nextInt(1..100)
                val result = a * b
                Arguments.of(Rectangle(a, b), result)
            }
        }

        @JvmStatic
        fun getValueForMultiSquare() =  listOf(
            Arguments.of(20, 30, 2, 1200),
            Arguments.of(40, 15, 3, 1800),
            Arguments.of(30, 10, 11, 3300),
            Arguments.of(50, 60, 9, 27000)
        )
    }
}