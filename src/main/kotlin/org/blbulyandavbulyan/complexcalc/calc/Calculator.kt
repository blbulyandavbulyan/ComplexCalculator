package org.blbulyandavbulyan.complexcalc.calc

import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber

/**
 * Данный класс предоставляет калькулятор комплексных чисел
 */
open class Calculator {
    /**
     * Данный метод выполняет вычисления результата бинарной операции над комплексными числами
     * @param a первый операнд
     * @param b второй операнд
     * @param operation бинарная операция, которую необходимо выполнить над операндами
     * @return комплексное число в результате операции
     */
    open fun calculate(a: ComplexNumber, b: ComplexNumber, operation: Operation): ComplexNumber {
        return when (operation) {
            Operation.ADD -> a + b
            Operation.SUB -> a - b
            Operation.DIV -> a / b
            Operation.MUL -> a * b
        }
    }
}