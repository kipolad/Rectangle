fun main() {
    val rectangle = Rectangle(3, 2)
    println("Create rectangle with sides: \na = ${rectangle.a}, b = ${rectangle.b}")

    println("Perimeter = ${rectangle.getPerimeter()}")

    println("Square = ${rectangle.getSquare()}")

    println("Double rectangle square = ${rectangle.getMultiSquare(5)}")

}