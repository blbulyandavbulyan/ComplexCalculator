package org.blbulyandavbulyan.complexcalc.calc

import org.blbulyandavbulyan.complexcalc.calc.exceptions.WrongExpressionException
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.toComplex
import java.lang.IllegalArgumentException

/**
 * Данный класс предназначен для разбора выражений, которые необходимо вычислить с участием комплексных чисел
 * @param calculator с помощью которого будут производиться вычисления над комплексными числами
 */
class ExpressionParser(private val calculator: Calculator) {
    /**
     * Данная функция вычисляет выражение в строковом формате с участием комплексных чисел
     * @param expression выражение, которое нужно вычислить
     */
    fun parse(expression: String): ComplexNumber {
        //здесь, первая группа в регулярном выражении - первый операнд
        //вторая группа оператор(оно же прописано в enum Operation)
        //третья группа - второй операнд

        val regex = Regex("(.*) (${Operation.entries.joinToString(separator = "|")}) (.*)")
        val resultMatch = regex.find(expression) ?: throw WrongExpressionException("You gave a wrong expression!")
        val groupValues = resultMatch.groupValues
        try {
            val a = groupValues[1].toComplex()
            val b = groupValues[3].toComplex()
            val operation = Operation.valueOf(groupValues[2])
            return calculator.calculate(a, b, operation)
        }
        catch (e: IllegalArgumentException){
            throw WrongExpressionException("You gave a wrong expression, operation is invalid!", e)
        }
        catch (e: WrongComplexNumber){
            throw WrongExpressionException("You gave a wrong expression, wrong complex number!", e)
        }
    }
}