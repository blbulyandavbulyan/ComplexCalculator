package org.blbulyandavbulyan.complexcalc.expressions

import org.blbulyandavbulyan.complexcalc.calc.Operation
import org.blbulyandavbulyan.complexcalc.calc.exceptions.WrongExpressionException
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ExpressionParserTest {
    private val expressionParser = ExpressionParser()

    @Test
    fun `test sum complex numbers`() {
        assertEquals(
            Expression(ComplexNumber(1.0, 1.0), ComplexNumber(1.0, 1.0), Operation.ADD),
            expressionParser.parse("1 + 1i ADD 1 + 1i")
        )
        assertEquals(
            Expression(ComplexNumber(2.234, 4.0), ComplexNumber(1.0, 1.0), Operation.ADD),
            expressionParser.parse("2.234 + 4i ADD 1 + 1i")
        )
    }

    @Test
    fun `test sub complex numbers`() {
        assertEquals(
            Expression(ComplexNumber(2.234, 4.0), ComplexNumber(1.0, 1.0), Operation.SUB),
            expressionParser.parse("2.234 + 4i SUB 1 + 1i")
        )
        assertEquals(
            Expression(ComplexNumber(2.234, 4.0), ComplexNumber(1.0, 10.23), Operation.SUB),
            expressionParser.parse("2.234 + 4i SUB 1 + 10.23i")
        )
    }

    @Test
    fun `test div complex numbers`() {
        assertEquals(
            Expression(
                ComplexNumber(0.5609756097560976, 0.04878048780487805),
                ComplexNumber(0.34615384615384615, 0.23076923076923078),
                Operation.DIV
            ),
            expressionParser.parse("0.5609756097560976 + 0.04878048780487805i DIV 0.34615384615384615 + 0.23076923076923078i")
        )
        assertEquals(
            Expression(ComplexNumber(2.234, 4.0), ComplexNumber(1.0, 1.0), Operation.DIV),
            expressionParser.parse("2.234 + 4i DIV 1 + 1i")
        )
    }

    @Test
    fun `should throw WrongExpressionException if operation is invalid`() {
        assertThrows(WrongExpressionException::class.java){
            expressionParser.parse("2.234 + 4i BLABLABLA 1 + 1i")
        }
    }
    @Test fun `should throw WrongExpressionException if there is an invalid complex number`(){
        assertThrows(WrongExpressionException::class.java){
            expressionParser.parse("2.234 + 4i ADD 1 + 1gi")
        }
        assertThrows(WrongExpressionException::class.java){
            expressionParser.parse("2.234 + 4ddi ADD 1 + 1i")
        }

    }
}