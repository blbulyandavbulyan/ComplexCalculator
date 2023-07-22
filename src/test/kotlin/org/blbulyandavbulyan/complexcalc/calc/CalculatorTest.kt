package org.blbulyandavbulyan.complexcalc.calc

import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun sum() {
        assertEquals(
            ComplexNumber(3.0, 4.0),
            calculator.calculate(ComplexNumber(1.5, 2.0), ComplexNumber(1.5, 2.0), Operation.ADD)
        )
        assertEquals(
            ComplexNumber(5.0, 10.0),
            calculator.calculate(ComplexNumber(3.0, 5.0), ComplexNumber(2.0, 5.0), Operation.ADD)
        )
    }
    @Test
    fun division(){
        assertEquals(
            ComplexNumber(0.34615384615384615, 0.23076923076923078),
            calculator.calculate(ComplexNumber(3.0, 3.0), ComplexNumber(10.0, 2.0), Operation.DIV)
        )
    }
    @Test
    fun subtraction(){
        assertEquals(
            ComplexNumber(0.0, 0.0),
            calculator.calculate(ComplexNumber(1.5, 2.0), ComplexNumber(1.5, 2.0), Operation.SUB)
        )
        assertEquals(
            ComplexNumber(1.0, 0.0),
            calculator.calculate(ComplexNumber(3.0, 5.0), ComplexNumber(2.0, 5.0), Operation.SUB)
        )
    }
    @Test
    fun multiplication() {
        assertEquals(
            ComplexNumber(-1.75, 6.0),
            calculator.calculate(ComplexNumber(1.5, 2.0), ComplexNumber(1.5, 2.0), Operation.MUL)
        )
        assertEquals(
            ComplexNumber(-19.0, 25.0),
            calculator.calculate(ComplexNumber(3.0, 5.0), ComplexNumber(2.0, 5.0), Operation.MUL)
        )
    }
}