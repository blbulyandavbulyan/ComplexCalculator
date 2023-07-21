package org.blbulyandavbulyan.complexcalc.calc

import org.blbulyandavbulyan.complexcalc.calc.exceptions.WrongExpressionException
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.toComplex
import java.lang.IllegalArgumentException

/**
 * Данный класс предоставляет калькулятор комплексных чисел
 */
open class Calculator {
    fun calculate(a: ComplexNumber, b: ComplexNumber, operation: Operation): ComplexNumber {
        return when (operation) {
            Operation.ADD -> a + b
            Operation.SUB -> a - b
            Operation.DIV -> a / b
            Operation.MUL -> a * b
        }
    }

    fun processExpression(expression: String): ComplexNumber {
        val regex = Regex("(.*) (ADD|SUB|DIV|MUL) (.*)")
        val resultMatch = regex.find(expression) ?: throw WrongExpressionException("You gave a wrong expression!")
        val groupValues = resultMatch.groupValues
        try {
            val a = groupValues[1].toComplex()
            val b = groupValues[3].toComplex()
            val operation = Operation.valueOf(groupValues[2])
            return calculate(a, b, operation)
        }
        catch (e: IllegalArgumentException){
            throw WrongExpressionException("You gave a wrong expression, operation is invalid!", e)
        }
        catch (e: WrongComplexNumber){
            throw WrongExpressionException("You gave a wrong expression, wrong complex number!", e)
        }
    }
}