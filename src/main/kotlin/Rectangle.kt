
class Rectangle(var a: Int = 1, var b: Int = 1) {
    init {
        if (a <= 0 || b <= 0) throw ArithmeticException("Side can't be less or equals than zero!")
    }

    fun getPerimeter() = (a + b) * 2

    fun getSquare() = a * b

    fun getMultiSquare(factor: Int) = getSquare() * factor
}